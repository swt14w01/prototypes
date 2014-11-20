package jrmds.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jrmds.controller.model.*;


@Repository
public interface RuleRepository extends CrudRepository<Component, Long> {
	Component findByRefID(String refID, ComponentType type);
}
