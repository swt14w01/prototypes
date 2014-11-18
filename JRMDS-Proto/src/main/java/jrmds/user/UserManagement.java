package jrmds.user;

import java.util.Set;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.stereotype.Controller;

import jrmds.controller.*;
import jrmds.controller.model.*;
import jrmds.user.model.*;

@Controller
public class UserManagement {
	@Autowired
	private GraphDatabaseService db;
	@Autowired
	private UserRepository Urepo;
	@Autowired 
	private JRMDS ctrl;
	
	public Boolean createUser(String forename, String surname) {
		RegisteredUser temp = new RegisteredUser(forename, surname);
		try (Transaction tx = db.beginTx()) {
			Urepo.save(temp);
			tx.success();
		}
		
		return true;
	}
	
	public Boolean userWorksOn(String surname, String p) {
		try (Transaction tx = db.beginTx()) {
			RegisteredUser temp=Urepo.findBySurname(surname);
			temp.worksWith(ctrl.getProject(p));
			Urepo.save(temp);
			tx.success();
		}
		return true;
	}
}
