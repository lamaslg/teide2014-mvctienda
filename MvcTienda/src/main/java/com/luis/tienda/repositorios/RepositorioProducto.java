package com.luis.tienda.repositorios;

import org.hibernate.Hibernate;

import com.luis.tienda.modelo.TiendaProducto;

public class RepositorioProducto 
			extends Repositorio<TiendaProducto> {

	@Override
	public TiendaProducto get(Class<TiendaProducto> tipo, int id) {
		// TODO Auto-generated method stub
		TiendaProducto p= super.get(tipo, id);
		
		Hibernate.initialize(p.getTiendaCategoria());
		
		return p;
	}
}
