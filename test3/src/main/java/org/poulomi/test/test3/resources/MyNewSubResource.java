package org.poulomi.test.test3.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/")
public class MyNewSubResource {

	
	  @GET
	  @Path("/{subresourceid}") 
	  public String mySubResourceMethod(@PathParam("subresourceid") String subresourceid,
			  @PathParam ("modelid") String modelid) { 
		  return "Model Id: " + modelid + ";subresourceid:" +subresourceid; }
	 
	
	
	@GET
	public String test() {
		return "new sub resource";
		
	}
}
