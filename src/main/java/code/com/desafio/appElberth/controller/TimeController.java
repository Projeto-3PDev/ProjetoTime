package code.com.desafio.appElberth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import code.com.desafio.appElberth.model.domain.Time;
import code.com.desafio.appElberth.model.service.TimeService;
import code.com.desafio.appElberth.model.service.UsuarioService;

@Controller
public class TimeController {
	
	@Autowired
	private TimeService timeService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/")
	public String inicializa() {
		return "index";
	}
	
	@GetMapping(value = "/time")
	public String telaCadastro(Model model){
		
		model.addAttribute("usuarioLista", usuarioService.obterLista());
		
		return "time/cadastro";
	}
	
	@GetMapping(value = "/time/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		
		Time timeExcluido = timeService.obterPorId(id);
		
		String msg = "Foi impossível realizar a exclusão";

		timeService.excluir(id);

		msg = "Time " + timeExcluido.getNome() + " excluído com sucesso!!!";

		model.addAttribute("mensagem", msg);
		
		return obterLista(model);
	}
	
	@PostMapping(value = "/time/incluir")
	public String incluir(Model model, Time time) {

		timeService.incluir(time);
		
		model.addAttribute("mensagem", "O time "+ time.getNome() +" foi cadastrado com sucesso!!!");
		
		return obterLista(model);
	}
	
	@GetMapping(value = "/time/{id}/consultar")
	public String consultar(Model model, @PathVariable Integer id) {
		
		Time time = timeService.obterPorId(id);
		
		model.addAttribute("meuTime", time);
		
		return telaCadastro(model);
	}
	
	@GetMapping(value = "/time/lista")
	public String obterLista(Model model) {

		model.addAttribute("times", timeService.obterLista());
		
		return "time/lista";
	}
	
	@GetMapping(value = "/voltar")
	public String voltar() {
		return "redirect:/time/lista";
	}
	
	@PostMapping(value = "/time/ordenar")
	public String ordenar(Model model, @RequestParam String sortBy) {		

		model.addAttribute("times", timeService.obterLista(sortBy));
		
		return "time/lista";
	}
}