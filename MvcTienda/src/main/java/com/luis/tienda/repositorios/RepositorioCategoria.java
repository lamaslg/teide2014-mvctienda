package com.luis.tienda.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luis.tienda.modelo.TiendaCategoria;

public class RepositorioCategoria 
				extends Repositorio<TiendaCategoria>{

	public Map<Integer,String> getMapaOptions(){
		
		Map<Integer,String> m=new HashMap<Integer, String>();
		List<TiendaCategoria> l=get(TiendaCategoria.class);
		for (TiendaCategoria tiendaCategoria : l) {
			m.put(tiendaCategoria.getIdCategoria(),
					tiendaCategoria.getNombre());
		}
		
		return m;
	}
}
