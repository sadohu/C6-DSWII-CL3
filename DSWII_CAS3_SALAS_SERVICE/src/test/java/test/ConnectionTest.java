package test;

import java.sql.Connection;

import connection.MySqlConnection;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection cn = MySqlConnection.conexion();
		if(cn != null)
			System.out.println("Conexion con base de datos Exitosa !!!");
	}

}
