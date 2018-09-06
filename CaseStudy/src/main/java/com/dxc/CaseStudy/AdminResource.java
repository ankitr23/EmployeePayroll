package com.dxc.CaseStudy;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import Employee.EmployeeDetails;
import EmployeeLeave.EmployeeLeave;
import Services.AdminService;


@Path("admin")
public class AdminResource {

	
	 @GET
	    @Path("viewallemp")
	    @Produces(MediaType.APPLICATION_JSON)
	 		public Response getAll() {
	    	
	    	return Response.ok(AdminService.viewAllEmp()).build();
	    	
	    }
//	    public ArrayList<EmployeeDetails> viewAllEmp() {
//	        ArrayList<EmployeeDetails> al=AdminService.viewAllEmp();
//	        return al;
//	    } 
	 
	 
	  
	    @POST
	    @Path("add")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response add(EmployeeDetails input)
	    {
	 
	    	AdminService.addEmployee(input);
	    	return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
	    			//.header("Access-Control-Allow-Origin", "*")
	    			.build();

	    }
	    @POST
	    @Path("payslip")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response salaryGen(Document doc) //empId
	    {
	    	ArrayList monthSalary=new ArrayList();
	    	monthSalary=AdminService.genPaySlip(doc);
	    	return Response.ok(monthSalary)
	    			//.header("Access-Control-Allow-Origin", "*")
	    			.build();

	    }
	    
	    @PUT
	    @Path("empleave")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response empLeave(EmployeeLeave emp)
	    {
	    	AdminService.empLeave(emp);
	    	return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added leave\"}")
	    			//.header("Access-Control-Allow-Origin", "*")
	    			.build();

	    }
}
