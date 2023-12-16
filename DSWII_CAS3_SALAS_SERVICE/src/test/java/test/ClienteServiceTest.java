package test;

import java.util.List;

import model.Cliente;
import service.ClienteService;
import servicesImpl.ClienteServiceImpl;

public class ClienteServiceTest {
	
	private static ClienteService service = new ClienteServiceImpl();

	public static void main(String[] args) {
		listar();
//		registrar("Aluze", "Luperdi", "12345678", "aluze@gmail.com");
//		buscar(2);
//		actualizar(2, "Donie", "Salazar", "87654321", "donie@gmail.com");
//		eliminar(2);
	}
	
	public static void listar(){
		List<Cliente> clientes = service.listar();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
	public static void buscar(int id){
		Cliente cliente = service.buscar(id);
		System.out.println(cliente);
	}
	
	public static void registrar(String nombre, String apellido, String dni, String correo){
		Cliente cliente = new Cliente(0, nombre, apellido, dni, correo);
		service.registrar(cliente);
		
		List<Cliente> clientes = service.listar();
		int lastIndex = clientes.size() - 1;
		System.out.println(clientes.get(lastIndex));
	}
	
	public static void actualizar(int id, String nombre, String apellido, String dni, String correo){
		Cliente cliente = new Cliente(id, nombre, apellido, dni, correo);
		service.actualizar(cliente);
		
		List<Cliente> clientes = service.listar();
		System.out.println(clientes.stream().filter(item -> item.getId() == id).findFirst().orElse(null));
	}
	
	public static void eliminar(int id){
		service.eliminar(id);
		
		List<Cliente> clientes = service.listar();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

}
