package com.luis.tienda.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.tienda.modelo.viewforms.ProductoView;
import com.luis.tienda.repositorios.RepositorioCategoria;
import com.luis.tienda.repositorios.RepositorioProducto;

@Controller
@RequestMapping(value="altaProducto.html")
public class ProductosAltaController {

	@Autowired
	RepositorioProducto daoP;
	@Autowired
	RepositorioCategoria daoC;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String alta(ModelMap modelo){
		
		ProductoView p=new ProductoView();
		
		modelo.addAttribute("producto",p);
		Map<Integer, String> cat=daoC.getMapaOptions();
		modelo.addAttribute("categorias",cat);
		
		return "alta";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String doAlta(@ModelAttribute("producto") ProductoView p,
			BindingResult result,
				HttpServletRequest req){
		
		if(result.hasErrors()){
			
			Map<Integer, String> cat=daoC.getMapaOptions();
			req.setAttribute("categorias",cat);
			return "alta";
		}
		
		daoP.add(p.getProducto());
		return "redirect:/listado.html";
	}
	
	
}
