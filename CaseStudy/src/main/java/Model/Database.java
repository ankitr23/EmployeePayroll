package Model;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import Employee.EmployeeDetails;
import Mapper.EmployeeMapper;

public class Database {

	private static final String DBNAME="demo2";
	private static final String ADMIN_LOGIN="admin";
	private static final String EMPLOYEE_LOGIN="employeelogin";
	private static final String EMPLOYEE_COLLECTION="employeedetails";
	private static final String EMPLOYEE_LEAVE ="employeeleave";

	private static MongoCollection<Document> adminLogin; 
	private static MongoCollection<Document> employeeLogin; 
	private static MongoCollection<Document> employeeDetails; 
	private static MongoCollection<Document> employeeLeave;
	
	public static void connect()
	{
		MongoClient mongo=new MongoClient("localhost",27017);
		MongoDatabase database=mongo.getDatabase(DBNAME);
		adminLogin=database.getCollection(ADMIN_LOGIN);
		employeeLogin=database.getCollection(EMPLOYEE_LOGIN);
		employeeDetails=database.getCollection(EMPLOYEE_COLLECTION);
		employeeLeave=database.getCollection(EMPLOYEE_LEAVE);
			
	}
	public static MongoCollection<Document> getAdminLogin()
	{
		return adminLogin;
	}
	public static MongoCollection<Document> getEmployeeLogin()
	{
		return employeeLogin;
	}
	public static MongoCollection<Document> getEmployeeDetails()
	{
		return employeeDetails;
	}
	
	public static MongoCollection<Document> getEmployeeLeave()
	{
		return employeeLeave;
	}
	

		
}
