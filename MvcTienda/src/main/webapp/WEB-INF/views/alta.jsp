<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" 
				prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form method="post" commandName="producto">

Nombre:<form:input path="nombre"/><br />
Precio:<form:input path="precio"/><br />
<form:errors path="precio"/>
Existencias:<form:input path="existencias"/><br />
<form:errors path="existencias"/>
Descripción:<form:textarea path="descripcion"/><br />
Categoria:<form:select path="idCategoria">
	<form:options items="${categorias}"/>
</form:select><br/>
<input type="submit" value="Enviar" />
</form:form>
</body>
</html>