package service;

import java.util.List;

import model.Cliente;

public interface ClienteService {
	public abstract List<Cliente> listar();

	public abstract Cliente buscar(int id);

	public abstract void registrar(Cliente cliente);

	public abstract void actualizar(Cliente cliente);

	public abstract void eliminar(int id);
}
