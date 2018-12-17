/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.dao;

import java.util.ArrayList;
import lds.entities.Employee;

public interface EmpDAO {
    ArrayList<Employee> getAllEmp();
    ArrayList<Employee> getEmpByName(String name);
    ArrayList<Employee> getEmpByStatus(String status);
    ArrayList<Employee> getEmpByPosition(String position);
    boolean insertEmp(Employee emp);
    boolean updateStat(String id, String stat);
    boolean deleteEmp(String id);
 }
