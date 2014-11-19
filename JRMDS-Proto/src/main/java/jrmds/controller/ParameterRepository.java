package jrmds.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jrmds.controller.model.*;

@Repository
public interface ParameterRepository extends CrudRepository<Parameter, Long> {
	Parameter findByName(String name);
}
