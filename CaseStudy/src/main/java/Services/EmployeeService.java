package Services;

import java.util.ArrayList;

import org.bson.Document;

import Employee.EmployeeDetails;
import Employee.EmployeeLogin;
import Mapper.EmployeeMapper;
import Model.AdminDatabase;
import Model.Database;
import Model.EmployeeDatabase;

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
}
