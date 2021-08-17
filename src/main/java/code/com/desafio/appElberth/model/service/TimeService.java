package code.com.desafio.appElberth.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.com.desafio.appElberth.model.domain.Time;
import code.com.desafio.appElberth.model.repository.TimeRepository;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository timeRepository;
	
	public List<Time> obterLista(){
		return (List<Time>) timeRepository.findAll();
	}
	
	public void incluir(Time time) {
		timeRepository.save(time);
	}
	
	public void excluir(Integer id) {
		timeRepository.deleteById(id);
	}
	
	public Optional<Time> obterPorId(Integer id) {
		return timeRepository.findById(id);
	}	
}