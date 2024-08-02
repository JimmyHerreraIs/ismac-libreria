package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

@Controller
@RequestMapping("/clientes") //Path Principal
public class ClienteController {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@GetMapping("/findAll")  //path Secundario
	public String findAll(Model model) {
		
		List<Cliente> clientes= clienteDAO.findAll();
		model.addAttribute("clientes", clientes);
		
		return "cliente-listar"; //nombre del formulario web Eje: cliente.listar.jsp
	}


@GetMapping("/findOne")//Se usa para actualizar o borrar un dato de un formulario web 
public String findOne(@RequestParam("idCliente")@Nullable Integer idCliente,
		@RequestParam("opcion")@Nullable Integer opcion
		,Model model) {
	//try {
		
		if(idCliente != null) {
			Cliente cliente =clienteDAO.findOne(idCliente);
			model.addAttribute("cliente",cliente);
		}
		if(opcion ==1) return "clientes-add"; //el formulario web clientes-add se usa para agregar o actualizar
		else return "clientes-del";
		
		
	//} catch (Exception e) {
		// TODO: handle exception
	//}
	
			
}

@PostMapping("/add")
public String add(@RequestParam("idCliente")@Nullable Integer idCliente
		,@RequestParam("cedula")@Nullable String cedula
		,@RequestParam("nombre")@Nullable String nombre
		,@RequestParam("apellido")@Nullable String apellido
		,@RequestParam("direccion")@Nullable String direccion
		,@RequestParam("telefono")@Nullable String telefono
		,@RequestParam("correo")@Nullable String correo	
		,Model model
		){
	
	//try {
		if(idCliente ==null) {
			Cliente cliente = new Cliente(0,cedula,nombre,apellido,direccion,telefono,correo);
			clienteDAO.add(cliente);
		}else {
			Cliente cliente = new Cliente(idCliente,cedula,nombre,apellido,direccion,telefono,correo);
			clienteDAO.up(cliente);
		}
		
		return "redirect:/clientes/findAll";
	//} catch (Exception e) {
		// TODO: handle exception
	//}
	
}

	@GetMapping("/del")
	public String del(@RequestParam("idCliente")@Nullable Integer idCliente) {
	//	try {
			clienteDAO.del(idCliente);
			return "redirect:/clientes/findAll";
		//} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
		//}
	
	}
}