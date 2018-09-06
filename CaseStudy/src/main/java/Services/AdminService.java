package Services;

import java.util.ArrayList;

import org.bson.Document;

import Employee.EmployeeDetails;
import EmployeeLeave.EmployeeLeave;
import Mapper.EmployeeLeaveMapper;
import Mapper.EmployeeMapper;
import Model.AdminDatabase;
import Model.Database;
import Model.EmployeeDatabase;
import Model.EmployeeLeaveDatabase;

public class AdminService {

	static
	{
		Database.connect();
	}
	
	
	
	public static void addEmployee(EmployeeDetails obj)
	{
		EmployeeService.addEmployee(obj);
	
	}
	
	public static ArrayList<EmployeeDetails> viewAllEmp()
	{
		
		ArrayList<EmployeeDetails> al =EmployeeService.viewAllEmp();
		return al;
	}
	public static ArrayList genPaySlip(Document doc) {
		EmployeeDetails emp=EmployeeService.getEmployeeDetails(doc);
		System.out.println("emp info"+emp);
		ArrayList a=new ArrayList<>();
		a=EmployeeDatabase.generatePaySlip(emp);
		//Document newSalary=new Document("monthSalary",updatedSalary);
		return a;
	}
	
	public static void empLeave(EmployeeLeave emp)
	{
		Document d = EmployeeLeaveMapper.toDocument(emp);
		EmployeeLeaveDatabase.employeeLeave(d);
	}
	
	
}
