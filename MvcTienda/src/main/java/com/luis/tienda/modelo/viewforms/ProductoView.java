package com.luis.tienda.modelo.viewforms;

import com.luis.tienda.modelo.TiendaCategoria;
import com.luis.tienda.modelo.TiendaProducto;



public class ProductoView {
	

	     private Integer idProducto;
	     private Integer idCategoria;
	     private String nombre;
	     private String descripcion;
	     private String foto;
	     private int existencias;
	     private double precio;
		public ProductoView() {
		}
		public ProductoView(Integer idProducto, Integer idCategoria,
				String nombre, String descripcion, String foto,
				int existencias, double precio) {
			this.idProducto = idProducto;
			this.idCategoria = idCategoria;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.foto = foto;
			this.existencias = existencias;
			this.precio = precio;
		}
		
		public TiendaProducto getProducto(){
			
			TiendaProducto tp=new TiendaProducto();
			tp.setNombre(nombre);
			tp.setDescripcion(descripcion);
			tp.setExistencias(existencias);
			tp.setFoto(foto);
			tp.setIdProducto(idProducto);
			tp.setPrecio(precio);
			
			TiendaCategoria tc=new TiendaCategoria();
			tc.setIdCategoria(idCategoria);
			
			tp.setTiendaCategoria(tc);
			
			return tp;
			
		}
		
		public void fromTiendaProducto(TiendaProducto tp){
			idProducto=tp.getIdProducto();
			nombre=tp.getNombre();
			existencias=tp.getExistencias();
			foto=tp.getFoto();
			descripcion=tp.getDescripcion();
			idCategoria=tp.getTiendaCategoria().getIdCategoria();
			
		}
		
		public Integer getIdProducto() {
			return idProducto;
		}
		public void setIdProducto(Integer idProducto) {
			this.idProducto = idProducto;
		}
		public Integer getIdCategoria() {
			return idCategoria;
		}
		public void setIdCategoria(Integer idCategoria) {
			this.idCategoria = idCategoria;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getFoto() {
			return foto;
		}
		public void setFoto(String foto) {
			this.foto = foto;
		}
		public int getExistencias() {
			return existencias;
		}
		public void setExistencias(int existencias) {
			this.existencias = existencias;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
	     
	     
	     
}
