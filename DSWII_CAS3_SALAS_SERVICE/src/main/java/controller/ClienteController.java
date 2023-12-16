package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.Cliente;
import service.ClienteService;
import servicesImpl.ClienteServiceImpl;

@Path("/cliente")
public class ClienteController {

	ClienteService service = new ClienteServiceImpl();
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		List<Cliente> clientes = service.listar();
		return Response.ok(clientes).build();
	}
	
	@GET
	@Path("/buscar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id") int id){
		Cliente cliente = service.buscar(id);
		if(cliente == null)
			return Response.status(Status.BAD_REQUEST).entity("Cliente no encontrado en BD").build();
		
		return Response.ok(cliente).build(); 
	}
	
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrar(Cliente cliente){
		service.registrar(cliente);
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Cliente cliente){
		Cliente clienteExists = service.buscar(cliente.getId());
		if(clienteExists == null)
			return Response.status(Status.BAD_REQUEST).entity("Cliente no encontrado en BD").build();
		
		service.actualizar(cliente);
		return Response.status(Status.CREATED).build();
	}
	
	@DELETE
	@Path("/eliminar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminar(@PathParam("id") int id){
		Cliente clienteExists = service.buscar(id);
		if(clienteExists == null)
			return Response.status(Status.BAD_REQUEST).entity("Cliente no encontrado en BD").build();
		
		service.eliminar(id);
		return Response.status(Status.CREATED).build();	 
	}
}
