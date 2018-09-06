package Services;

import java.util.ArrayList;

import org.bson.Document;

import Employee.EmployeeDetails;
import Employee.EmployeeLogin;
import Mapper.EmployeeMapper;
import Model.AdminDatabase;
import Model.Database;
import Model.EmployeeDatabase;
import Model.EmployeeLeaveDatabase;


public class EmployeeService {

	static
	{
		Database.connect();
	}
//	public static boolean update(int empId,EmployeeDetails emp)
//	{
//		return Database.updatePassword(empId, emp);
//	}
	public static void addEmployee(EmployeeDetails emp)
	{
		
		 EmployeeDatabase.addEmployee(EmployeeMapper.toDocument(emp));
	}
	
	public static EmployeeDetails getEmployeeDetails(Document doc)
	{
		String empId=doc.getString("empId");
		EmployeeDetails emp=EmployeeDatabase.getEmployeeDetails(empId);
		return emp;
	}
	
	public static ArrayList<EmployeeDetails> viewAllEmp()
	{
		
		ArrayList<EmployeeDetails> al =EmployeeDatabase.viewAllEmp();
		return al;
	}

	public static boolean updatePassword(Document doc) {
		String empId = doc.getString("empId");
		String oldPass=doc.getString("oldpassword");
		String newPass=doc.getString("newpassword");
		return EmployeeDatabase.updatePassword(empId,oldPass,newPass);
	}

	public static EmployeeDetails getEmpProfile(String empId) {
		  EmployeeDetails emp=EmployeeDatabase.getEmpProfile(empId);
		  return emp;
	}

	public static Document viewLeave(String month, String empId) {
		 return EmployeeLeaveDatabase.viewLeave(month,empId);
	}

	public static Document monthWithMaxLeaves(String empId) {
		return EmployeeLeaveDatabase.monthWithMaxLeaves(empId);
	}

	public static ArrayList monthsWithLeaves(String empId) {
		 return EmployeeLeaveDatabase.monthsWithLeaves(empId);
	}


}
