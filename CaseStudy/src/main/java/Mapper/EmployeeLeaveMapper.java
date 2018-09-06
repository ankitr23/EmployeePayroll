package Mapper;

import org.bson.Document;

import EmployeeLeave.EmployeeLeave;


public class EmployeeLeaveMapper {

	public static EmployeeLeave toObject(Document d)
	{
		EmployeeLeave emp = new EmployeeLeave();
		emp.setEmpId(d.getString("empId"));
		emp.setName(d.getString("name"));
		emp.setEmpId(d.getString("date"));
		emp.setEmpId(d.getString("month"));
		emp.setEmpId(d.getString("year"));
		emp.setEmpId(d.getString("atdFlag"));
		
		return emp;
		
	}
	
	public static Document toDocument(EmployeeLeave emp)
	{
		Document d = new Document()
				.append("empId", emp.getEmpId())
				.append("name", emp.getName())
				.append("date", emp.getDate())
				.append("month", emp.getMonth())
				.append("year", emp.getYear())
				.append("atdFlag", emp.getAtdFlag());
		return d;
	}
}
