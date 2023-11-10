package com.mais_saude.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mais_saude.repository.UsuariosReposiroty;
import com.mais_saude.model.UsuariosModel;
@Controller
public class UsuariosController {

	@Autowired
	private UsuariosReposiroty usuariorepository;
	
	@GetMapping("/")
	public String Usuarios(Model model) {
	model.addAttribute("usuarios", usuariorepository.findAll());
	
		return "/usuarios";
	}
	@GetMapping("/cadastro-de-usuario")
	public String Novo(Model model) {
	
		return "/cadastro";
	}
	@PostMapping(value="/usuario/criar")
		public ModelAndView UsuarioModel(UsuariosModel usuarios) {
		ModelAndView mv = new ModelAndView("redirect:/");
		usuariorepository.save(usuarios);
		
		return mv;
	}
	@GetMapping("/deletar/{id}")
		public String Deletar(UsuariosModel usuario,@PathVariable("id") long id ) {
		usuario = (UsuariosModel)this.usuariorepository.getOne(id);
		this.usuariorepository.delete(usuario);
	
		return"redirect:/";
	}
	//  @GetMapping("/administradores/{id}/excluir")
	  //public String excluir(@PathVariable int id){
	    //repo.deleteById(id);
	    //return "redirect:/administradores";
	  //}
	
	
	  @GetMapping("/{id}")
	  public String busca(@PathVariable long id, Model model){
	    Optional<UsuariosModel> usuarios = usuariorepository.findById(id);
	    try{
	      model.addAttribute("usuarios", usuarios.get());
	    }
	    catch(Exception err){ return "redirect:/"; }

		return ("/alterar");
	  }

	  
	//  @PostMapping("/administradores/{id}/atualizar")
	//  public String atualizar(@PathVariable int id, Administrador administrador){
	  //  // if(!repo.exist(id)){
	    //if(!repo.existsById(id)){
	     // return "redirect:/administradores";
	   // }
	
}
