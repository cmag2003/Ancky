package com.muebleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.muebleria.model.Usuario;
import com.muebleria.repository.ITipoUsuarioRepository;
import com.muebleria.repository.IUsuariosRepository;

@Controller
public class ProyectoController {
	
	@Autowired
	private ITipoUsuarioRepository repoTipoUsua;
	@Autowired
	private IUsuariosRepository repoUsua;
	
	@GetMapping("/")
	public String cargarPagPrincipal() {
		return "principal";
	}
	@GetMapping("/login")
	public String cargarPagLogin(@ModelAttribute("usuarios") Usuario usuario, Model model) {
		
		
		
		System.out.println(usuario);
		try {
			repoUsua.save(usuario);
			model.addAttribute("mensaje", "usuario registrado");
			model.addAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al Registrar");
			model.addAttribute("clase", "alert alert-danger");
		}
		
		model.addAttribute("lstTipoUsuario", repoTipoUsua.findAll());
		model.addAttribute("usuarios", new Usuario());
		return "Login";
		
	}
}
