package service;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Cliente;

public class ClienteService {
	
	public List<Cliente> listar() throws JsonParseException, JsonMappingException, IOException{
		Response response = null;
		WebTarget webTarget;
		Client client = ClientBuilder.newClient();
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<Cliente> clientes = null;
		String responseJson = null;
		
		webTarget = client.target("http://localhost:8080/DSWII_CAS3_SALAS_SERVICE/api/cliente/listar");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		
		if(response.getStatus() != 200)
			System.out.println("Out of Range");
		
		responseJson = response.readEntity(String.class);
		clientes = objectMapper.readValue(responseJson, new TypeReference<List<Cliente>>() {});
		return clientes;
	}
	
	public Cliente buscar(int id) throws JsonParseException, JsonMappingException, IOException{
		Response response = null;
		WebTarget webTarget;
		Client client = ClientBuilder.newClient();
		ObjectMapper objectMapper = new ObjectMapper();
		
		Cliente cliente = null;
		String responseJson = null;
		
		webTarget = client.target("http://localhost:8080/DSWII_CAS3_SALAS_SERVICE/api/cliente/buscar/" + id);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		
		if(response.getStatus() != 200 && response.getStatus() != 404)
			System.out.println("Out of Range");
		
		if(response.getStatus() == 404)
			System.out.println("Cliente no encontrado");
		
		responseJson = response.readEntity(String.class);
		cliente = objectMapper.readValue(responseJson, Cliente.class);
		
		return cliente;
	}
	
	public void registrar(Cliente cliente){
		// Set interaces
		Client client = ClientBuilder.newClient();
		WebTarget webTarget;
		Response response = null;
		
		// Implementation
		webTarget = client.target("http://localhost:8080/DSWII_CAS3_SALAS_SERVICE/api/cliente/registrar");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.post(Entity.entity(cliente, MediaType.APPLICATION_JSON));
		
		// Validation: Ok Status
		if(response.getStatus() != 201)
			System.out.println("Error al crear el cliente: " + response.getStatus());
			
		System.out.println("Cliente creado exitosamente.");
	}
	
	public void actualizar(Cliente cliente){
		// Set interaces
		Client client = ClientBuilder.newClient();
		WebTarget webTarget;
		Response response = null;
		
		// Implementation
		webTarget = client.target("http://localhost:8080/DSWII_CAS3_SALAS_SERVICE/api/cliente/actualizar");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.put(Entity.entity(cliente, MediaType.APPLICATION_JSON));
		
		// Validation: Ok Status
		if(response.getStatus() != 201)
			System.out.println("Error al actualizar el cliente: " + response.getStatus());
			
		System.out.println("Usuario actualizado exitosamente.");
	}
	
	public void eliminar(int id) throws JsonParseException, JsonMappingException, IOException{
		// Set Interfaces
		Response response = null;
		WebTarget webTarget;
		Client client = ClientBuilder.newClient();
		
		webTarget = client.target("http://localhost:8080/DSWII_CAS3_SALAS_SERVICE/api/cliente/eliminar/" + id);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.delete();
		
		// Validation: Ok Status
		if(response.getStatus() != 201 && response.getStatus() != 400)
			System.out.println("Out of Range");
		
		if(response.getStatus() == 400)
			System.out.println("Cliente no encontrado");
		
		System.out.println("Cliente eliminado exitosamente.");
	}
}
