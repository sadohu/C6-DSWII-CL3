package servicesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.MySqlConnection;
import model.Cliente;
import service.ClienteService;

public class ClienteServiceImpl implements ClienteService {

	@Override
	public List<Cliente> listar() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "SELECT * FROM tbl_clientecl3";

		try {
			connection = MySqlConnection.conexion();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Cliente cliente = new Cliente(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
				clientes.add(cliente);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}

		return clientes;
	}

	@Override
	public Cliente buscar(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Cliente cliente = null;
		String sql = "SELECT * FROM tbl_clientecl3 where idcodcl3 = ?";

		try {
			connection = MySqlConnection.conexion();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				cliente = new Cliente(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}

		return cliente;
	}

	@Override
	public void registrar(Cliente cliente) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO tbl_clientecl3 (nomcl3, apellcl3, dnicl3, correocl3) VALUES (?, ?, ?, ?)";

		try {
			connection = MySqlConnection.conexion();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getNombre());
			preparedStatement.setString(2, cliente.getApellido());
			preparedStatement.setString(3, cliente.getDni());
			preparedStatement.setString(4, cliente.getCorreo());
			int resultSet = preparedStatement.executeUpdate();
			if (resultSet > 0) {
				System.out.println("Cliente regitrado");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	@Override
	public void actualizar(Cliente cliente) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE tbl_clientecl3 SET nomcl3 = ?, apellcl3 = ?, dnicl3 = ?, correocl3 = ? WHERE idcodcl3 = ?";

		try {
			connection = MySqlConnection.conexion();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getNombre());
			preparedStatement.setString(2, cliente.getApellido());
			preparedStatement.setString(3, cliente.getDni());
			preparedStatement.setString(4, cliente.getCorreo());
			preparedStatement.setInt(5, cliente.getId());
			int resultSet = preparedStatement.executeUpdate();
			if (resultSet > 0) {
				System.out.println("Cliente actualizado");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	@Override
	public void eliminar(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM tbl_clientecl3 WHERE idcodcl3 = ?";

		try {
			connection = MySqlConnection.conexion();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int resultSet = preparedStatement.executeUpdate();
			if (resultSet > 0) {
				System.out.println("Cliente eliminado");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

}
