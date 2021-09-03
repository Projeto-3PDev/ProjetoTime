<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>MyTeam</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
		
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container">
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success alert-dismissible">
			    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			    <strong>Informação!</strong> ${mensagem}
			</div>
		</c:if>
	
		<h3><a href="/usuario">Incluir um novo usuário</a></h3>
	
		<c:if test="${not empty usuarios}">  		
		  	<h2>Listagem de usuários: ${usuarios.size()}</h2>
		  	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>Id</th>
			      <th>Nome</th>
			      <th>E-mail</th>
			      <th>Times</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="usuario" items="${usuarios}">
				    <tr>
				      <td>${usuario.id}</td>
				      <td>${usuario.nome}</td>
				      <td>${usuario.email}</td>
				      <td>${usuario.times.size()}</td>
				      <td><a href="/usuario/${usuario.id}/excluir">Excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>
		
		<c:if test="${empty usuarios}">  		
		  	<h2>Não existem usuários cadastrados!!!</h2>
		</c:if>		
	</div>
</body>
</html>