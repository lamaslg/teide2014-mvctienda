package com.luis.tienda.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.tienda.modelo.TiendaProducto;
import com.luis.tienda.modelo.viewforms.ProductoView;
import com.luis.tienda.repositorios.RepositorioCategoria;
import com.luis.tienda.repositorios.RepositorioProducto;


@Controller

public class ModificarProductoController {

	@Autowired
	RepositorioProducto daoP;
	@Autowired
	RepositorioCategoria daoC;
	
	
	@RequestMapping(value="/modificarProducto_{id}.html",
			method=RequestMethod.GET)
	public String modificar(ModelMap modelo,@PathVariable int id){
		
		
		ProductoView p=new ProductoView();
		TiendaProducto tp=daoP.get(TiendaProducto.class, id);
		p.fromTiendaProducto(tp);
		
		modelo.addAttribute("producto",p);
		Map<Integer, String> cat=daoC.getMapaOptions();
		modelo.addAttribute("categorias",cat);
		
		return "modificar";
	}
	@RequestMapping(value="/modificarProducto_{id}.html",
			method=RequestMethod.POST)
	public String doAlta(@ModelAttribute("producto") ProductoView p,
			BindingResult result,
				HttpServletRequest req){
		
		if(result.hasErrors()){
			
			Map<Integer, String> cat=daoC.getMapaOptions();
			req.setAttribute("categorias",cat);
			return "modificar";
		}
		TiendaProducto tp=p.getProducto();
		daoP.update(tp);
		
		return "redirect:/listado.html";
	}
	
}
