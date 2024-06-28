package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

public class PrincipalAutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Patron de IoC o Inversión de Control
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 		
		AutorDAO autorDAO = context.getBean("autorDAOImpl2", AutorDAO.class);
		
		// CRUD : CREATE, READ UPDATE y DELETE
		// add
		Autor autor = new Autor(0,"juan","taipe","pais","direccion","0987654321","jtaipe@correo.com");
		//autorDAO.add(autor);		
		// up
		Autor autor2 = new Autor(55,"juan2","taipe2","pais2","direccion2","09876543212","jtaipe2@correo.com");
		autorDAO.up(autor2);
		// del
		//autorDAO.del(40);
		// findOne
		System.out.println("**************** DEL *************"+autorDAO.findOne(40));
		// findAll
		//List<Autor> Autors = autorDAO.findAll(); 		
		autorDAO.findAll().forEach(item -> { System.out.println(item.toString()); });
		
		context.close();
		
	}

}
