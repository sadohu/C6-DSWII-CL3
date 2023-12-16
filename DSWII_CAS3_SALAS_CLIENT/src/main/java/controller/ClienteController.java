package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

/**
 * Servlet implementation class ClienteController
 */
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ClienteService service = new ClienteService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		Cliente cliente = null;
		List<Cliente> clientes = null;
		int id = 0;

		if (action != null) {
			switch (action) {
			case "create":
				request.getRequestDispatcher("/registrar.jsp").forward(request, response);
				break;

			case "read":
				clientes = service.listar();
				request.setAttribute("list", clientes);
				request.getRequestDispatcher("/listar.jsp").forward(request, response);
				break;

			case "update":
				id = Integer.parseInt(request.getParameter("id"));
				cliente = service.buscar(id);
				request.setAttribute("cliente", cliente);
				request.getRequestDispatcher("/actualizar.jsp").forward(request, response);
				break;

			case "delete":
				id = Integer.parseInt(request.getParameter("id"));
				cliente = service.buscar(id);
				if (cliente != null)
					service.eliminar(id);

				clientes = service.listar();
				request.setAttribute("list", clientes);
				request.getRequestDispatcher("/listar.jsp").forward(request, response);
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		String correo = request.getParameter("correo");

		Cliente cliente = new Cliente();

		int id = 0;
		if (idString != null)
			id = Integer.parseInt(idString);

		cliente.setId(id);
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setDni(dni);
		cliente.setCorreo(correo);

		if (id == 0)
			service.registrar(cliente);
		else
			service.actualizar(cliente);

		List<Cliente> clientes = service.listar();
		request.setAttribute("list", clientes);

		request.getRequestDispatcher("/listar.jsp").forward(request, response);
	}

}
