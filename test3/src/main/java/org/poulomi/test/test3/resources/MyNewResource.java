package org.poulomi.test.test3.resources;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.server.Uri;
import org.poulomi.test.test3.resources.service.ServiceClass;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriInfo;

@Path("mynewresource")
public class MyNewResource {
	static List<MyModel> mmList=new ArrayList<MyModel>();
	ServiceClass sc = new ServiceClass();
	

	@GET
	@Path("/xmlresource")
	@Produces(MediaType.APPLICATION_XML)
	public MyModels getXmlData(){
		/*
		 * MyModel mm = new MyModel("Poulomi", "Mukherjee", 33); mmList.add(mm);
		 */
		//return sc.getAllModels();
		//return mmList;
		
		List<MyModel>  modelList=sc.getAllModels();
		MyModels myModels=new MyModels();
		myModels.setModelList(modelList);
		
		return myModels;
		
	}
	
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<MyModel> myMethod() throws
	 * Exception { //MyModel mm = new MyModel("Poulomi", "Mukherjee", 33);
	 * 
	 * JAXBContext context = JAXBContext.newInstance(MyModel.class); StringWriter
	 * stringWriter = new StringWriter(); //return Response.status(0).build();
	 * List<MyModel> mmList=new ArrayList<MyModel>(); mmList.add(mm); return
	 * context.createMarshaller().marshal(mmList, stringWriter);
	 * 
	 * return sc.getAllModels(); }
	 * 
	 * 
	 * @GET
	 * 
	 * @Path("/{message}")
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String myMethod2(@PathParam("message")
	 * String message) throws Exception{ //return "test"; return message; }
	 */

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public void addModel(MyModel myModel) {
		sc.addMyModel(myModel);
	}

	// Accessing QueryParam
	@GET
	public String getQueryParam(@QueryParam("year") int year) {
		return "The year is :" + year;
	}

	@Path("/{modelid}/subresources")
	public MyNewSubResource subResourceTesting() {
		return new MyNewSubResource();
	}
	
	//Using a custom status code
	@POST
	@Path("/posttest")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPostModel(MyModel myModel) {
	    return Response.status(Status.CREATED).entity(myModel).build();
		//return mmList;
	}
	
	//accessing the url
		@POST
		@Path("/posttest2")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response addPostModel(MyModel myModel,@Context UriInfo uriInfo) {
			//return Response.status(Status.CREATED).entity(myModel).build();
			//return mmList;
			return Response.created(uriInfo.getAbsolutePathBuilder().path("/poulomi").build())
					.entity(myModel)
					.build();
		}
		
}
