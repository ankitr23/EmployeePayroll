package com.dxc.CaseStudy;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	    
	

}
