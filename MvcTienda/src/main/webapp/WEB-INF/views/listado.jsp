<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<table>
<c:forEach items="${productos }" var="producto">
<tr>
<td>${producto.nombre }</td>
<td>${producto.precio }</td>
<td><a href="detalle_${producto.idProducto}.html">Detalle</a>
<a href="#" onclick="detalle(${producto.idProducto})">Detalle ajax</a>
</td>
</tr>
</c:forEach>

</table>

<div id="divDetalle"></div>
<script type="text/javascript" 
	src='<c:url value="/resources/js/jquery.js"/>'></script>

<script type="text/javascript">
function detalle(id){
var url="producto/"+id;
$.get(url,function(res){
		var resultado="<ul>";
		resultado+="<li>"+res.nombre+"</li>";
		resultado+="<li>"+res.precio+"</li>";
		resultado+="<li>"+res.existencias+"</li>";
		resultado+="<li>"+res.tiendaCategoria.nombre+"</li>";
		resultado+="</ul>";
		$("#divDetalle").html(resultado);
	});
}


</script>
</body>
</html>