package test;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import model.Cliente;
import service.ClienteService;

public class ClienteServiceTest {
	
	private static ClienteService service = new ClienteService();

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		listar();
//		registrar("Aluze", "Luperdi", "12345678", "aluze@gmail.com");
//		buscar(6);
//		actualizar(6, "Yasha", "Luperdi", "25419835", "yasha@gmail.com");
//		eliminar(6);
	}
	
	public static void listar() throws JsonParseException, JsonMappingException, IOException{
		List<Cliente> clientes = service.listar();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
	public static void buscar(int id) throws JsonParseException, JsonMappingException, IOException{
		Cliente cliente = service.buscar(id);
		System.out.println(cliente);
	}
	
	public static void registrar(String nombre, String apellido, String dni, String correo) throws JsonParseException, JsonMappingException, IOException{
		Cliente cliente = new Cliente(0, nombre, apellido, dni, correo);
		service.registrar(cliente);
		
		List<Cliente> clientes = service.listar();
		int lastIndex = clientes.size() - 1;
		System.out.println(clientes.get(lastIndex));
	}
	
	public static void actualizar(int id, String nombre, String apellido, String dni, String correo) throws JsonParseException, JsonMappingException, IOException{
		Cliente cliente = new Cliente(id, nombre, apellido, dni, correo);
		service.actualizar(cliente);
		
		List<Cliente> clientes = service.listar();
		System.out.println(clientes.stream().filter(item -> item.getId() == id).findFirst().orElse(null));
	}
	
	public static void eliminar(int id) throws JsonParseException, JsonMappingException, IOException{
		service.eliminar(id);
		
		List<Cliente> clientes = service.listar();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

}
