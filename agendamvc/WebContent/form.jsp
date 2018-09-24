<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Adicionar Livro</h1>
	<form action="sistema" method="post">
		<input type="hidden" name="comando" value="InserirLivro">
		<div>
			<label>Titulo: </label> 
			<input type="text" name="titulo">
		</div>
		<div>
			<label>Autor: </label> 
			<input type="text" name="autor">
		</div>
		<div>
			<label>Editora: </label> 
			<input type="text" name="editora">
		</div>
		<div>
			<label>Publicação: </label>
			<input type="text" name="anoPublicado">
		</div>
		<div>
			<label>Edição: </label>
			<input type="text" name="edicao">
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>
</body>
</html>



