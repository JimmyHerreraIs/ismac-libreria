package com.distribuida.principal;


import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Date;

import com.distribuida.dao.AutorDAO;
import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.LibroDAO;
import com.distribuida.dao.LibroDAOImpl;
import com.distribuida.entities.Categoria;
import com.distribuida.entities.Libro;

public class PrincipalLibro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Patron de IoC o Inversión de Control
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 		
		LibroDAO LibroDAO = context.getBean("LibroDAOImpl", LibroDAO.class);
		ClienteDAO  clientenDAO= context.getBean("clienteDAOImpl", ClienteDAO.class);
		// CRUD : CREATE, READ UPDATE y DELETE
		// add
		//Libro Libro = new Libro(1,"Infierno","Marquiños",520,"Primera edicion","Español",new Date(),"Un mundo de marravillas misteriosas","Dura","12-12-34",10,"Infierno","Original",24.45,"Historia", 'Pamela');
		//Libro.setCliente(clientenDAO.findOne(2));
		//LibroDAO.add(Libro);
		
		
		//LibroDAO.up(Libro2);
		// up
		//Libro Libro2 = new Libro(40,"17894561232","juan2","taipe2","0987643212","direccion2","jtaipe2@correo.com");
		//LibroDAO.up(Libro2);
		// del
		//LibroDAO.del(1);
		// findOne
		System.out.println("**************** DEL *************"+LibroDAO.findOne(40));
		// findAll
		//List<Libro> Libros = LibroDAO.findAll(); 		
		LibroDAO.findAll().forEach(item -> { System.out.println(item.toString()); });
		
		context.close();
		
	}

}
