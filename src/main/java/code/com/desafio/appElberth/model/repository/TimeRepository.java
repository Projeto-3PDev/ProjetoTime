package code.com.desafio.appElberth.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import code.com.desafio.appElberth.model.domain.Time;

@Repository
public interface TimeRepository extends CrudRepository<Time, Integer> {

	public List<Time> findAll(Sort sort);
}