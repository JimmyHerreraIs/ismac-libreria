package com.distribuida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.dao.FacturaDAO;
import com.distribuida.dao.Factura_detalleDAO;
import com.distribuida.dao.LibroDAO;

@Controller
@RequestMapping("/facturacion")
public class FacturacionController {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private LibroDAO libroDAO;
	
	@Autowired
	private FacturaDAO facturaDAO;
	
	@Autowired
	private Factura_detalleDAO facturaDetalleDAO;
	
	@GetMapping("/principal")
	public String principal() {
		return "principal";
	}
	@GetMapping("/findAll")
	public String findAll(ModelMap modelMap) {
		modelMap.addAttribute("facturas", facturaDAO.findAll());
		
		return "faturacion-listar";
	}
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idFactura")@Nullable Integer idFactura
			, ModelMap modelMap) {
		modelMap.addAttribute("factura", facturaDAO.findOne(idFactura));
		
		return "facturacion-listar";
	}
	
	@GetMapping("/findOneCliente")
	public String findOneCliente(@RequestParam("idCliente")@Nullable Integer idCliente,	ModelMap modelMap) {
		
		modelMap.addAttribute("cliente", clienteDAO.findOne(idCliente));
			return "redirect:/facturacion/principal";}
			
	
}
