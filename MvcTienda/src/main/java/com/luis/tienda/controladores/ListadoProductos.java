package com.luis.tienda.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.tienda.modelo.TiendaProducto;
import com.luis.tienda.repositorios.RepositorioProducto;

@Controller
public class ListadoProductos {

	@Autowired
	RepositorioProducto dao;
	@RequestMapping(value="listado.html",method=RequestMethod.GET)
	public String listado(Model modelo) {
		
		List<TiendaProducto> productos=dao.get(TiendaProducto.class);
		modelo.addAttribute("productos", productos);
		
		return "listado";
		
		
	}
	@RequestMapping(value="/detalle_{id}.html")
	public String detalle(Model modelo,@PathVariable int id){
		
		TiendaProducto tp=dao.get(TiendaProducto.class,id);
		
		modelo.addAttribute("producto", tp);
		return "detalle";
		
	}
}





