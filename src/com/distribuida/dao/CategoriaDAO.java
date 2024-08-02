package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Categoria;

public interface CategoriaDAO {

	// CRUD básico 
	public List<Categoria> findAll();
	
	public Categoria findOne(int id);
	
	public void add(Categoria Categoria);
	
	public void up(Categoria Categoria);
	
	public void del(int id);

	// CRUD avanzados
	
}
