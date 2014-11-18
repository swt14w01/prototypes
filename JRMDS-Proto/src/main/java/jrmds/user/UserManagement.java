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
	
	public RegisteredUser getUser(String surname) {
		RegisteredUser temp = null;
		try (Transaction tx= db.beginTx()) {
			temp=Urepo.findBySurname(surname);
			tx.success();
		}
		return temp;
	}
	
	public Boolean createUser(String forename, String surname) {
		if (getUser(surname)==null) {
			try (Transaction tx = db.beginTx()) {
				RegisteredUser temp = new RegisteredUser(forename, surname);
				Urepo.save(temp);
				tx.success();
			}
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean userWorksOn(String surname, String p) {
		Boolean booli=false;
		try (Transaction tx = db.beginTx()) {
			RegisteredUser temp=Urepo.findBySurname(surname);
			booli=temp.worksWith(ctrl.getProject(p));
			Urepo.save(temp);
			tx.success();
		}
		return booli;
	}
}
