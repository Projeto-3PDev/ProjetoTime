package code.com.desafio.appElberth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import code.com.desafio.appElberth.model.domain.Usuario;
import code.com.desafio.appElberth.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuario/lista")
	public String obterLista(Model model) {
		
		model.addAttribute("usuarios", usuarioService.obterLista());
		
		return "usuario/lista";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String incluir(Model model, Usuario usuario) {
		
		usuarioService.incluir(usuario);
		
		model.addAttribute("mensagem", "O usuário " + usuario.getNome() + " foi incluído com sucesso!");
		
		return obterLista(model);
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		
		Usuario usuario = usuarioService.obterPorId(id);
		
		usuarioService.excluir(id);
		
		model.addAttribute("mensagem", "O usuário " + usuario.getNome() + " foi excluído com sucesso!");
		
		return obterLista(model);
	}
}