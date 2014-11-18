package jrmds.user;

import java.util.Set;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.Fetch;
import jrmds.controller.model.*;
import jrmds.user.model.*;


public class UserManagement {
	@Autowired
	private GraphDatabaseService db;
	@Autowired
	private UserRepository Urepo;
	
	public Boolean createUser(String forename, String surname) {
		RegisteredUser temp = new RegisteredUser(forename, surname);
		Transaction tx = db.beginTx();
		Urepo.save(temp);
		tx.success();
		tx.close();
		
		return true;
	}
	
	public Boolean userWorksOn(RegisteredUser u, Project p) {
		Transaction tx = db.beginTx();
		RegisteredUser temp=Urepo.findOne(u.getID());
		temp.worksWith(p);
		tx.success();
		tx.close();
		return true;
	}
}
