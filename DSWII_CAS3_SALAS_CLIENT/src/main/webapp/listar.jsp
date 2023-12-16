<%@page import="model.Cliente"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Clientes</title>
</head>
<body bgcolor="#c5dec9">
	<h1 align="center">Consumiendo WEB SERVICE REST con Base de Datos</h1>
	<h2 align="center">Listado de clientes</h2>
	<a href="ClienteController?action=create" style="margin: 0 15%;">Registrar nuevo Cliente</a>
	<table style="margin: 0 auto;">
		<tr>
			<th>Codigo</th>
			<th>Nombre del Cliente</th>
			<th>Apellido del Cliente</th>
			<th>DNI</th>
			<th>Correo</th>
			<th colspan="2">Acciones</th>
		</tr>

		<%
			List<Cliente> clientes = (List<Cliente>) request.getAttribute("list");
			if (clientes != null) {
				for (Cliente cliente : clientes) {
		%>

		<tr>
			<td><%=cliente.getId()%></td>
			<td><%=cliente.getNombre()%></td>
			<td><%=cliente.getApellido()%></td>
			<td><%=cliente.getDni()%></td>
			<td><%=cliente.getCorreo()%></td>
			<td><a
				href="ClienteController?action=update&id=<%=cliente.getId()%>">Actualizar</a></td>
			<td><a
				href="ClienteController?action=delete&id=<%=cliente.getId()%>">Eliminar</a></td>
		</tr>

		<%
			}
			}
		%>
	</table>
</body>