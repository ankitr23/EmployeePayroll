package Mapper;

import org.bson.Document;

import Employee.EmployeeLogin;

public class EmployeeLoginMapper {

	public static EmployeeLogin toObject(Document d)
	{
		EmployeeLogin emp = new EmployeeLogin();
		emp.setEmpId(d.getString("empId"));
		emp.setPassword(d.getString("password"));
		return emp;
	}
}
