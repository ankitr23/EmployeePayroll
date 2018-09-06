package com.dxc.CaseStudy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import Services.EmployeeService;


@Path("employee")
public class EmployeeResource {

	
	 @POST
	    @Path("changepass")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public String  updatepassword(Document doc) //old password,new password
	    {
	    	
	       boolean state=EmployeeService.updatePassword(doc);
	       if(state)
	       return "ok";
	       else
	    	   return "not updated.. try again";
	    }
	    
	 @GET
	 @Path("viewprofile/{empId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response getdetails (@PathParam("empId") String empId)
	 {
		 return Response.ok(EmployeeService.getEmpProfile(empId)).build();
	
	 }
	 
	 @GET
	 @Path("monthsWithLeaves/{empId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response monthsWithLeaves (@PathParam("empId") String empId)
	 {

	    	return Response.ok(EmployeeService.monthsWithLeaves(empId)).build();
	 }
 
	 @GET
	 @Path("monthsWithMaxLeaves/{empId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response monthsWithMaxLeaves (@PathParam("empId") String empId)
	 {

	    	return Response.ok(EmployeeService.monthWithMaxLeaves(empId)).build();
	 }
	 
	 @GET
	 @Path("viewleave/{month}/{empId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response viewLeave(@PathParam("month") String month,@PathParam("empId") String empId)
	 {

	    	return Response.ok(EmployeeService.viewLeave(month,empId)).build();
	 }
}
