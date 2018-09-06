package Model;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;

import Employee.EmployeeDetails;
import Mapper.EmployeeMapper;

public class EmployeeDatabase {

	private static MongoCollection<Document> employeeDetails;
	static
	{
		employeeDetails=Database.getEmployeeDetails();
	}
	
	public static void updatePassword(int empId, EmployeeDetails emp)
	{
		Bson d = new Document("empId",empId);
		Bson value = new Document("password",emp.getPassword());
		Bson updatePassword = new Document("$set", value);
		employeeDetails.updateOne(d, updatePassword);
	}

	public static void addEmployee(Document document) {
		employeeDetails.insertOne(document);
		
	}
	
	public static ArrayList<EmployeeDetails> viewAllEmp()
	{
		ArrayList<EmployeeDetails> al= new ArrayList<EmployeeDetails>();
		FindIterable<Document> ftr = employeeDetails.find();
		Iterator<Document> it= ftr.iterator();
		while(it.hasNext())
		{
			Document d = (Document)it.next();
			EmployeeDetails emp = EmployeeMapper.toObject(d);
			al.add(emp);
		}
		return al;
	}
	public static ArrayList generatePaySlip(EmployeeDetails emp) //admin
	{
		double totalSalary=0;
		double salary=emp.getSalary();
		System.out.println(salary);
		//calculations to perform
		double hra = 0.25*salary;
		double ca = 0.1 * salary;
		double pf = 0.05*salary;
		double pt= 0.05*salary;
		totalSalary = ((salary +hra +ca)-(pf+pt)); 
		Document d = new Document();
		d.append("salary", salary).append("hra", hra).append("ca", ca).append("pf", pf)
		.append("pt", pt).append("totalSalary", totalSalary);
		ArrayList al = new ArrayList();
		al.add(d);
		System.out.println(totalSalary);
		return al;
		
	}
	public static EmployeeDetails getEmployeeDetails(String empId) {
		FindIterable<Document> ftr = employeeDetails.find(Filters.eq("empId", empId));
		return EmployeeMapper.toObject(ftr.first());
	}

	public static boolean updatePassword(String empId,String oldPass, String newPass) {
		
		Document password=new Document("password",oldPass).append("empId", empId);
		Document set = new Document("$set", new Document("password", newPass));
		UpdateResult result= employeeDetails.updateOne(password, set);
		return result.wasAcknowledged();
	}
}
