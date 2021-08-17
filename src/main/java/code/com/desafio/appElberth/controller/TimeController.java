package code.com.desafio.appElberth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import code.com.desafio.appElberth.model.domain.Time;
import code.com.desafio.appElberth.model.service.TimeService;

@Controller
public class TimeController {
	
	@Autowired
	private TimeService timeService;
	
	@GetMapping(value = "/")
	public String inicializa() {
		return "index";
	}
	
	@GetMapping(value = "/time")
	public String telaCadastro(){
		return "time/cadastro";
	}
	
	@GetMapping(value = "/time/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		
		Optional<Time> timeExcluido = timeService.obterPorId(id);
		
		String msg = "Foi impossível realizar a exclusão";

		if(timeExcluido.isPresent()) {
			timeService.excluir(id);
			
			Time time = timeExcluido.get();
			
			msg = "Time " + time.getNome() + " excluído com sucesso!!!";
		}
		
		model.addAttribute("mensagem", msg);
		
		return obterLista(model);
	}
	
	@PostMapping(value = "/time/incluir")
	public String incluir(Model model, Time time) {

		timeService.incluir(time);
		
		model.addAttribute("mensagem", "O time "+ time.getNome() +" foi cadastrado com sucesso!!!");
		
		return obterLista(model);
	}
	
	@GetMapping(value = "/time/consultar")
	public String consultar() {
		return "";
	}
	
	@GetMapping(value = "/time/lista")
	public String obterLista(Model model) {

		model.addAttribute("times", timeService.obterLista());
		
		return "time/lista";
	}
}