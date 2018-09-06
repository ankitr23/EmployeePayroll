package Model;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

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


	public static ArrayList viewAllEmpLeaves() {
	
		int empLeavesSize;
		String name;
		ArrayList al1=new ArrayList();
		ArrayList al2=new ArrayList();
		al1.add(Aggregates.group("$date", Accumulators.sum("total", 1)));
		Iterator it1=employeeLeave.aggregate(al1).iterator();
		while(it1.hasNext())
		{
			al2.add(it1.next());
		}
		empLeavesSize=al2.size();
		System.out.println("Total:"+empLeavesSize);
		ArrayList al3=new ArrayList();
		ArrayList al4=new ArrayList();
		Document d=new Document();
		d.append("_id", 1);
		al3.add(Aggregates.match(Filters.eq("atdFlag", "false")));
   		al3.add(Aggregates.group("$empId", Accumulators.sum("count", 1)));
   		al3.add(Aggregates.sort(d));
		Iterator it2=employeeLeave.aggregate(al3).iterator();
		while(it2.hasNext())
		{
			al4.add(it2.next());
		}
		ArrayList al5=new ArrayList();
		Iterator it3=al4.iterator();
		while(it3.hasNext())
		{
			Document doc=(Document)it3.next();
			String empId=doc.getString("_id");
			int count=doc.getInteger("count");
			
			System.out.println();
			System.out.println("Emp Id "+empId);
			System.out.println("Leaves: "+count);
		
			FindIterable<Document> fitr2=employeeLeave.find(Filters.eq("empId",empId));
			Iterator it4 = fitr2.iterator();
			{
				Document nameDoc=new Document();
				nameDoc=(Document)it4.next();
				name=nameDoc.getString("name");
				System.out.println(it4.next());
			}


				Document result=new Document();
				result.append("empId", empId)
					  .append("name", name)
					  .append("count", count);
				al5.add(result);
			}
		
		return al5;

	}


	public static Document viewLeave(String month, String empId) {
		int leave;
		int present;
		Document d=new Document();
		ArrayList al1=new ArrayList();
		ArrayList al2=new ArrayList();
		al1.add(Aggregates.match(Filters.eq("empId", empId)));
		al1.add(Aggregates.match(Filters.eq("atdFlag", "false")));
		al1.add(Aggregates.match(Filters.eq("month", month)));
		Iterator it1=employeeLeave.aggregate(al1).iterator();
		while(it1.hasNext())
		{
			al2.add(it1.next());
		}
		leave=al2.size();
		
		ArrayList al3=new ArrayList();
		ArrayList al4=new ArrayList();
		al3.add(Aggregates.match(Filters.eq("empId", empId)));
		al3.add(Aggregates.match(Filters.eq("atdFlag", "true")));
		al3.add(Aggregates.match(Filters.eq("month", month)));
		Iterator it2=employeeLeave.aggregate(al3).iterator();
		while(it2.hasNext())
		{
			al4.add(it2.next());
		}
		present=al4.size();
		d.append("present", present).append("leave", leave);
		return d;
	}


	public static Document monthWithMaxLeaves(String empId) {
		ArrayList al1=new ArrayList();
		Document d=new Document();
		d.append("leave", -1);
		al1.add(Aggregates.match(Filters.eq("empId", empId)));
		al1.add(Aggregates.match(Filters.eq("atdFlag", "false")));
   		al1.add(Aggregates.group("$month", Accumulators.sum("leave", 1)));
   		al1.add(Aggregates.sort(d));
   		al1.add(Aggregates.limit(1));
   		Iterator it=employeeLeave.aggregate(al1).iterator();
   		Document d1=(Document)it.next();
		System.out.println(d1);
		return d1;
	}


	public static ArrayList monthsWithLeaves(String empId) {
		ArrayList al1=new ArrayList();
		ArrayList al2=new ArrayList();
		al1.add(Aggregates.match(Filters.eq("empId", empId)));
		al1.add(Aggregates.match(Filters.eq("atdFlag", "false")));
   		al1.add(Aggregates.group("$month", Accumulators.sum("leave", 1)));
   		Iterator it=employeeLeave.aggregate(al1).iterator();
		while(it.hasNext())
		{
			Document doc=(Document)it.next();
			al2.add(doc);
		}
		return al2;
	}


	
}
