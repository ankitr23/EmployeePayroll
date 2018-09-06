package EmployeeLeave;

public class EmployeeLeave {

	private String empId;
	private String name;
	private String date;
	private String month;
	private String year;
	private String atdFlag;
	public EmployeeLeave()
	{
		
	}
	public EmployeeLeave(String empId, String name, String date, String month, String year, String atdFlag) {
		super();
		this.empId = empId;
		this.name = name;
		this.date = date;
		this.month = month;
		this.year = year;
		this.atdFlag = atdFlag;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAtdFlag() {
		return atdFlag;
	}
	public void setAtdFlag(String atdFlag) {
		this.atdFlag = atdFlag;
	}
	
	
}
