package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Autor;

public interface AutorDAO {
	//	CRUD básico 
	public List<Autor> findAll();
	
	public Autor findOne(int id);
	
	public void add(Autor Autor);
	
	public void up(Autor Autor);
	
	public void del(int id);

	// CRUD avanzados
}
