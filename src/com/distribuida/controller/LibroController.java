package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.AutorDAO;
import com.distribuida.dao.CategoriaDAO;
import com.distribuida.dao.LibroDAO;
import com.distribuida.entities.Libro;

@Controller
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	private LibroDAO libroDAO;
	
	@Autowired
	private AutorDAO autorDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@GetMapping("/findAll")
	private String findAll(ModelMap modelMap) {
		List<Libro> libros = libroDAO.findAll();
		modelMap.addAttribute("libros", libros);
		return "libros-listar";
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idLibro")@Nullable Integer idLibro
			, @RequestParam("opcion")@Nullable Integer opcion
			, ModelMap modelMap 
			) {
		if(idLibro !=null) {
			Libro libro= libroDAO.findOne(idLibro);
			modelMap.addAttribute("libro", libro);
		}
		
		modelMap.addAttribute("autores", autorDAO.findAll());
		modelMap.addAttribute("categoria", categoriaDAO.findAll());
		
		if(opcion == 1)return "libros-add";
		else return "libros-del";
	}
	
	@PostMapping("/add")
	public String add() {
		
		return "redirect:/libros/findAll";
	}
	}
}
