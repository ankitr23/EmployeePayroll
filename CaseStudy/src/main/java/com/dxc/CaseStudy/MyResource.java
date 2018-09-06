package com.dxc.CaseStudy;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import Employee.EmployeeDetails;
import Services.AdminService;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
   
  
    
//    @PUT
//    @Path("employee/update/{empId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response update(@PathParam("empId") int empId, EmployeeDetails input)
//    {
//    	if()
//    }
    
// 	@PUT
//    @Path("teacher/update/{rollno}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response update (@PathParam("rollno") String rollno,StudentDetails input)
//    {
//    	if(TeacherService.update(rollno, input))
//    	return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
//    			.build();
//    else
//    	return Response.ok("{\"status\":\"1\",\"message\":\"Roll no. not found\"}").build();
//    }
}
