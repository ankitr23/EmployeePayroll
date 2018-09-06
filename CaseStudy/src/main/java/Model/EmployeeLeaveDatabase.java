package Model;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class EmployeeLeaveDatabase {

	
	private static MongoCollection<Document> employeeLeave;
	static
	{
		employeeLeave=Database.getEmployeeLeave();
	}
	
	
	public static void employeeLeave(Document d)
	{
		employeeLeave.insertOne(d);
	}
}
