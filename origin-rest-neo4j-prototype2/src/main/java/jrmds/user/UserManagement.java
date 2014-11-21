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
	private UserRepository UserRepository;
	@Autowired 
	private JrmdsMainController ctrl;
	
	public RegisteredUser getUser(String username) {
		RegisteredUser temp = null;
		try (Transaction tx= db.beginTx()) {
			temp=UserRepository.findByUsername(username);
			tx.success();
		}
		return temp;
	}
	

	public Boolean createUser(String username, String password, String emailAdress) {
		if (getUser(username)==null) {

			try (Transaction tx = db.beginTx()) {
				RegisteredUser temp = new RegisteredUser(username, password, emailAdress);
				UserRepository.save(temp);
				tx.success();
			}
			return true;
		} else {
			return false;
		}
	}
	

	public boolean userWorksOn(RegisteredUser u, Project p) {
		boolean booli=u.worksOn(p);
		if (booli) try (Transaction tx = db.beginTx()) {
			UserRepository.save(u);

			tx.success();
		}
		return booli;
	}
}
