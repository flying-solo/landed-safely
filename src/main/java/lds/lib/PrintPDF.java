/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */

package lds.lib;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JTable;



public class PrintPDF {
    
    private final JTable table;
    private final String dtCategory;

    public PrintPDF(JTable table, String dtCat) {
        this.table = table;
        this.dtCategory = dtCat;
    }
    
    public void print() {
        Document doc = new Document(PageSize.A4.rotate());
        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(dtCategory+".pdf"));
            
            doc.open();
            PdfContentByte cb = writer.getDirectContent();
            
            cb.saveState();
            Graphics2D g2d = cb.createGraphicsShapes(500, 500);
            
            Shape oldClip = g2d.getClip();
            g2d.clipRect(0, 0, 500, 500);
            
            this.table.print(g2d);
            g2d.setClip(oldClip);
            
            g2d.dispose();
            cb.restoreState();
        } catch (DocumentException | FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        doc.close();
    }
    
}
