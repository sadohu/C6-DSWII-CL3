package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private static String url = "jdbc:mysql://localhost:3307/bdsalas";
	private static String usuario = "root1";
	private static String password = "123456";
	private static Connection cn;

	public static Connection conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, usuario, password);
			if (cn != null) {
				System.out.println("Conexion con base de datos Exitosa !!!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cn;
	}
}
