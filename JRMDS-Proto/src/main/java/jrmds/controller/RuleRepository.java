package jrmds.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jrmds.controller.model.*;


@Repository
public interface RuleRepository extends CrudRepository<Component, Long> {
	Constraint findByRefID(String RefID, ComponentType type);
}
