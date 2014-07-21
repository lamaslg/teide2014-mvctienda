package com.luis.tienda.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value="/buscar/{texto}",
			method=RequestMethod.GET)
	public @ResponseBody List<TiendaProducto> 
			buscar(@PathVariable String texto){
		
		Map<String,	Object> params=new HashMap<String, Object>();
		if(texto.equals("NoBuscoNada"))
			texto="";
		
		params.put("nombre", "%"+texto+"%");
		
		List<TiendaProducto> l=dao.find("Producto.Buscar", params);
		return l;
		
		
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody 
							TiendaProducto producto){
		
		dao.delete(producto);
		
		return "OK";
	}
	
}





