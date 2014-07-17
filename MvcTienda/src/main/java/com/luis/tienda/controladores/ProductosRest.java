package com.luis.tienda.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luis.tienda.modelo.TiendaProducto;
import com.luis.tienda.repositorios.RepositorioProducto;


@Controller
@RequestMapping(value="/producto")
public class ProductosRest {
@Autowired
	RepositorioProducto dao;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public @ResponseBody TiendaProducto detalle
								(@PathVariable int id){
		
		TiendaProducto p=dao.get(TiendaProducto.class, id);
		
		return p;
		
		
	}
	
}
