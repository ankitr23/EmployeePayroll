package Model;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import Employee.EmployeeDetails;
import Services.EmployeeService;

public class AdminDatabase {

	private static MongoCollection<Document> adminLogin;
	static
	{
		adminLogin=Database.getAdminLogin();
	}
	
}
