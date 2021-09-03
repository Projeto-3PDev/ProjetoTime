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
	
	<c:set var="titulo" value="Cadastramento de times"/>
	<c:set var="rota" value="/time/incluir"/>
	<c:set var="metodo" value="post"/>
	<c:set var="botao" value="Cadastrar"/>

	<c:if test="${not empty meuTime}">
		<c:set var="titulo" value="Consulta de time"/>
		<c:set var="rota" value="/voltar"/>
		<c:set var="metodo" value="get"/>
		<c:set var="botao" value="Voltar"/>
	</c:if>	
	
	<div class="container">	
	  	<h2>${titulo}</h2>
	  	
		<form action="${rota}" method="${metodo}">

		    <div class="form-group">
		      <label>Usuário:</label>
				<select class="form-control" name="usuario.id">			        
			        <c:forEach var="u" items="${usuarioLista}">
			        	<option value="${u.id}">${u.nome}</option>
			        </c:forEach>			        
		      	</select>
		    </div>

		    <div class="form-group">
		      <label>Nome:</label>
		      <input type="text" class="form-control" value="${meuTime.nome}" placeholder="Entre com o nome do time" name="nome">
		    </div>

		    <div class="form-group">
		      <label>Ano de fundação:</label>
		      <input type="text" class="form-control" value="${meuTime.anoFundacao}" placeholder="Entre com o ano de fundação do time" name="anoFundacao">
		    </div>

		    <button type="submit" class="btn btn-default">${botao}</button>
		</form>	  	
	</div>
</body>
</html>