/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib.Libs;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import lds.main.MainFrm;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Print {
    
    private final String dtCategory;
    private final MainFrm main = new MainFrm();
    private final String home = System.getProperty("user.home");
    

    public Print(String dtCat) {
        this.dtCategory = dtCat;
    }
    
    public void printXLS(JTable table) {
        try {
            TableModel tbModel = table.getModel();
            TableColumnModel tcm = table.getColumnModel();
            
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet fSheet = wb.createSheet("new Sheet");
            HSSFCellStyle cellStyle = wb.createCellStyle();
            
            HSSFRow hRow = fSheet.createRow((short) 0);
            for(int j = 0; j < tcm.getColumnCount(); j++) {                       
               HSSFCell cell = hRow.createCell((short) j);
               cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());
               cell.setCellStyle(cellStyle);
            }
            
            
            for (int i = 0; i < tbModel.getRowCount(); i++) {
                HSSFRow fRow = fSheet.createRow((short) i+1);
                for (int j = 0; j < tbModel.getColumnCount(); j++) {
                    HSSFCell cell = fRow.createCell((short) j);
                    cell.setCellValue(tbModel.getValueAt(i, j).toString());
                    cell.setCellStyle(cellStyle);
                }
            }
            FileOutputStream outStream;
            outStream = new FileOutputStream(home +"/Documents/"+ dtCategory +".xls");
            try (BufferedOutputStream bos = new BufferedOutputStream(outStream)) {
                wb.write(bos);
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append("XLS exported to /home/Documents/");
            String ttl = "LDS : Information";
            int type = JOptionPane.INFORMATION_MESSAGE;
            this.main.userDialog(sb, ttl, type);
            outStream.close();
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to export XLS. \n");
            sb.append(e.getMessage());
            String ttl = "LDS : Error";
            int type = JOptionPane.ERROR_MESSAGE;
            this.main.userDialog(sb, ttl, type);
        }
    }
    
    public void printPDF(JTable table) {
        Document doc = new Document(PageSize.A4.rotate());
        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(home +"/Documents/"+ dtCategory +".pdf"));
            
            doc.open();
            PdfContentByte cb = writer.getDirectContent();
            
            cb.saveState();
            Graphics2D g2d = cb.createGraphicsShapes(500, 500);
            
            Shape oldClip = g2d.getClip();
            g2d.clipRect(0, 0, 500, 500);
            
            table.print(g2d);
            g2d.setClip(oldClip);
            
            g2d.dispose();
            cb.restoreState();
            
            StringBuilder sb = new StringBuilder();
            sb.append("PDF exported to /home/Documents/");
            String ttl = "LDS : Information";
            int type = JOptionPane.INFORMATION_MESSAGE;
            this.main.userDialog(sb, ttl, type);
        } catch (DocumentException | FileNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to export PDF. \n");
            sb.append(e.getMessage());
            String ttl = "LDS : Error";
            int type = JOptionPane.ERROR_MESSAGE;
            this.main.userDialog(sb, ttl, type);
        }
        doc.close();
    }

}
