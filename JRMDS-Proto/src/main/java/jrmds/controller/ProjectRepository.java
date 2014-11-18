package jrmds.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jrmds.controller.model.*;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
}