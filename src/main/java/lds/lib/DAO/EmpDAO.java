/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.Employee;

public interface EmpDAO {
    ArrayList<Employee> getAllEmp();
    ArrayList<Employee> getEmpByName(String name);
    ArrayList<Employee> getEmpByStatus(String status);
    ArrayList<Employee> getEmpByPosition(String position);
    boolean insertEmp(Employee emp);
    boolean updateStat(String id, String status);
    boolean updatePosition(String id, String position);
    boolean deleteEmp(String id);
 }
