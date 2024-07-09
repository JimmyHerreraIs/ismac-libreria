package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Factura_detalle;

public interface Factura_detalleDAO {

	// CRUD básico 
	public List<Factura_detalle> findAll();
	
	public int findOne(int id);
	
	public void add(Factura_detalle Factura_detalle);
	
	public void up(Factura_detalle Factura_detalle);
	
	public void del(int id);

	// CRUD avanzados
	
}
