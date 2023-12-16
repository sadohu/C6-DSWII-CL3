<%@page import="model.Cliente"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Cliente</title>
</head>
<body bgcolor="#c5dec9">
	<h1 align="center">Actualizar Cliente</h1>

	<table border="2" align="center">
		<form action="ClienteController" method="post">
			<%Cliente cliente = (Cliente) request.getAttribute("cliente");%>
			<input type="hidden" name="id" value="<%=cliente.getId()%>">
		<tr>
			<td>Nombre de Cliente</td>
			<td><input type="text" name="nombre"
				value="<%=cliente.getNombre()%>"></td>
		</tr>

		<tr>
			<td>Apellido de Cliente</td>
			<td><input type="text" name="apellido"
				value="<%=cliente.getApellido()%>"></td>
		</tr>

		<tr>
			<td>DNI de Cliente</td>
			<td><input type="text" name="dni"
				value="<%=cliente.getDni()%>"></td>
		</tr>

		<tr>
			<td>Correo de Cliente</td>
			<td><input type="text" name="correo"
				value="<%=cliente.getCorreo()%>"></td>
		</tr>

		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-primary" value="Actualizar Cliente"></td>
		</tr>
		</form>
	</table>
</body>