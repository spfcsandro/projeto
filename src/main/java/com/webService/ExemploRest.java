package com.webService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/exemplo")
public class ExemploRest {
	
	 private List<String> list = new ArrayList<String>();
	 
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("/")
	    public List<String> hello() {
	        list.add("Hello");
	        list.add("Word");
	        list.add("Tutorial");
	        return list;
	    }
}
