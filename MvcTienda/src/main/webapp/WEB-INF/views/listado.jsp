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
Buscar:<input type="text" id="txtBuscar" /> 
<input type="button" value="Buscar" onclick="buscar()"/>
<table id="tblDatos">
<c:forEach items="${productos }" var="producto">
<tr>
<td>${producto.nombre }</td>
<td>${producto.precio }</td>
<td><a href="detalle_${producto.idProducto}.html">Detalle</a>
<a href="#" onclick="detalle(${producto.idProducto})">Detalle ajax</a>
<a href="#" onclick="borrar(${producto.idProducto})">Borrar</a>

</td>
</tr>
</c:forEach>

</table>

<div id="divDetalle"></div>
<script type="text/javascript" 
	src='<c:url value="/resources/js/jquery.js"/>'></script>

<script type="text/javascript">
function borrar(id){

	var datos={idProducto:id};

	var datosPasar=JSON.stringify(datos);

	$.ajax(
			"producto",{
				data:datosPasar,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("Empleado borrado correctamente");
					$("#txtBuscar").text("");
					buscar();

					},
				error: function(res){
					alert(JSON.stringify(res));
					}


				}
			);



	
}


function buscar(){
	var tx=$("#txtBuscar").val();
	if(tx=="")
		tx="NoBuscoNada";
	var url="producto/buscar/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});



		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td>"+res[i].precio+"</td>";
			h+="<td><a href='detalle.html?id="+
					res[i].idProducto+"'>Detalle</a> ";
			h+="<a href='#' onclick='detalle("+
				res[i].idProducto+")'>Detalle ajax</a> ";
			h+="<a href='#' onclick='borrar("+
				res[i].idProducto+")'>Borrar</a></td>";
			h+="</tr>";	
			tabla.append(h);
			}



		

		});
	
}
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