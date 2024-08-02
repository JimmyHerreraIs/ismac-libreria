package com.distribuida.principal;


import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.dao.Factura_detalleDAO;
import com.distribuida.dao.Factura_detalleDAOImpl;
import com.distribuida.entities.Factura_detalle;

public class PirincipalFactura_detalle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Patron de IoC o Inversión de Control
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 		
		Factura_detalleDAO Factura_detalleDAO = context.getBean("Factura_detalleDAOImpl", Factura_detalleDAO.class);
		ClienteDAO  clientenDAO= context.getBean("Factura_detalleDAOImpl", ClienteDAO.class);
		// CRUD : CREATE, READ UPDATE y DELETE
		// add
		Factura_detalle factura_detalle = new Factura_detalle(1,23,2);
		//factura_detalle.setIdfacturadetalle(Factura_detalleDAO.findOne(1));
		Factura_detalleDAO.add(factura_detalle);
		
		
		//Factura_detalleDAO.up(Factura_detalle2);
		// up
		//Factura_detalle Factura_detalle2 = new Factura_detalle(40,"17894561232","juan2","taipe2","0987643212","direccion2","jtaipe2@correo.com");
		//Factura_detalleDAO.up(Factura_detalle2);
		// del
		//Factura_detalleDAO.del(1);
		// findOne
		System.out.println("**************** DEL *************"+Factura_detalleDAO.findOne(40));
		// findAll
		//List<Factura_detalle> Factura_detalles = Factura_detalleDAO.findAll(); 		
		Factura_detalleDAO.findAll().forEach(item -> { System.out.println(item.toString()); });
		
		context.close();
		
	}

}
