package jrmds.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jrmds.model.*;


@Repository
public interface UserRepository extends CrudRepository<RegisteredUser, Long> {
	
}