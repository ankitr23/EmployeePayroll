package Mapper;

import org.bson.Document;

import Employee.EmployeeDetails;

public class EmployeeMapper {

	public static EmployeeDetails toObject(Document d)
	{
		EmployeeDetails em = new EmployeeDetails();
		em.setEmpId(d.getString("empId"));
		em.setName(d.getString("name"));
		em.setPassword(d.getString("password"));
		em.setFatherName(d.getString("fatherName"));
		em.setMotherName(d.getString("motherName"));
		System.out.println("before mobile in mapper");

		em.setMobile(d.getString("mobile"));
		em.setEmail(d.getString("email"));
		em.setAddress(d.getString("address"));
		em.setDesignation(d.getString("designation"));
		em.setDob(d.getString("dob"));
		em.setGender(d.getString("gender"));
		
		em.setSalary(d.getDouble("salary"));
		System.out.println("saal");
		return em;
	}
	
	public static Document toDocument(EmployeeDetails empl)
	{
		Document doc=new Document()
				.append("empId", empl.getEmpId())
				.append("name", empl.getName())
				.append("password",empl.getPassword())
				.append("fatherName", empl.getFatherName())
				.append("motherName", empl.getMotherName())
				.append("mobile", empl.getMobile())
				.append("email", empl.getEmail())
				.append("address", empl.getAddress())
				.append("designation", empl.getDesignation())
				.append("dob", empl.getDob())
				.append("gender", empl.getGender())
				.append("salary", empl.getSalary());
		return doc;
	}
}
