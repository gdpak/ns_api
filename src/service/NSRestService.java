package service;

import java.net.URI;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import domain.VirtualLink;
import domain.VirtualLinkManager;

@Path("/ns")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

public class NSRestService {
	@Context
	private UriInfo uriInfo;
	/*
	 * CRUD on VL
	 */
	/*
	 * Create a VL
	 * @param VL 
	 */
	@POST
	@Path("vl")
	public Response create(VirtualLink vl) {
		if (vl == null)
			throw new BadRequestException();
		VirtualLinkManager.add(vl);
		URI uri = uriInfo.getAbsolutePathBuilder()
				.path(String.valueOf(vl.getId()))
				.build();
		return Response.created(uri).build();
	}
	
	/*
	 * Get a vl
	 * @param id of the vl to retreive
	 * @return the status and food
	 */
	@GET
	@Path("/vl/{name}")
	public Response get(@PathParam("name") int id) {
		System.out.println("id = "+ id);
		VirtualLink vl = VirtualLinkManager.find(id);
		if (vl == null)
			throw new NotFoundException();
		return Response.ok(vl).build();
	}
}
