package com.distribuida.principal;


import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.dao.FacturaDAOImpl;
import com.distribuida.entities.Factura;

public class PirincipalFactura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Patron de IoC o Inversión de Control
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 		
		FacturaDAO facturaDAO = context.getBean("facturaDAOImpl", FacturaDAO.class);
		ClienteDAO  clientenDAO= context.getBean("clienteDAOImpl", ClienteDAO.class);
		// CRUD : CREATE, READ UPDATE y DELETE
		// add
		Factura factura = new Factura(0,"FAC-0090",new Date(), 23.36,5.36,30.68);
		factura.setCliente(clientenDAO.findOne(2));
		facturaDAO.add(factura);
		
		Factura factura2 = new Factura(1,"FAC-0001",new Date(), 23.36,5.36,30.68);
		factura.setCliente(clientenDAO.findOne(3));
		//facturaDAO.up(factura2);
		// up
		//Factura factura2 = new Factura(40,"17894561232","juan2","taipe2","0987643212","direccion2","jtaipe2@correo.com");
		//facturaDAO.up(factura2);
		// del
		//facturaDAO.del(1);
		// findOne
		System.out.println("**************** DEL *************"+facturaDAO.findOne(40));
		// findAll
		//List<Factura> Facturas = FacturaDAO.findAll(); 		
		facturaDAO.findAll().forEach(item -> { System.out.println(item.toString()); });
		
		context.close();
		
	}

}
