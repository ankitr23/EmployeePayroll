package Employee;

import java.util.Date;

public class EmployeeDetails {

	private String empId;
	private String name;
	private String password;
	private String fatherName;
	private String motherName;
	private String mobile;
	private String email;
	private String address;
	private String designation;
	private String dob;
	private String gender;
	private double salary;
	
	public EmployeeDetails()
	{
		
	}
	
	public EmployeeDetails(String empId, String name, String password, String fatherName, String motherName,
			String mobile, String email, String address, String designation, String dob, String gender, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.password = password;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.designation = designation;
		this.dob = dob;
		this.gender = gender;
		this.salary = salary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	

	



}
