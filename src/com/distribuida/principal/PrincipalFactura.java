package com.distribuida.principal;


import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.entities.Factura;

public class PrincipalFactura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Patron de IoC o Inversión de Control
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 		
		FacturaDAO facturaDAO = context.getBean("FacturaDAOImpl", FacturaDAO.class);
		ClienteDAO clienteDAO = context.getBean("clienteDAOImpl", ClienteDAO.class);
		
		// CRUD : CREATE, READ UPDATE y DELETE
		// add
		Factura factura = new Factura(0,"FAC-00010",new Date(),23.36,5.36,30.68);
		factura.setCliente(clienteDAO.findOne(2));
		facturaDAO.add(factura);		
		// up
		Factura factura2 = new Factura(87,"FAC-00010",new Date(),23.36,5.36,30.68);
		factura.setCliente(clienteDAO.findOne(3));
		facturaDAO.up(factura2);
		// del
		facturaDAO.del(87);
		// findOne
		System.out.println("**************** DEL *************"+facturaDAO.findOne(87));
		// findAll
		//List<Factura> Facturas = FacturaDAO.findAll(); 		
		facturaDAO.findAll().forEach(item -> { System.out.println(item.toString()); });
		
		context.close();
		
	}

}
