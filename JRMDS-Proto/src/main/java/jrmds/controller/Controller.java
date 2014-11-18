package jrmds.controller;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import jrmds.model.*;


public class Controller {
	@Autowired
	private GraphDatabaseService db;
	
	@Autowired
	private RuleRepository Rrepo;
	
	@Autowired
	private ProjectRepository Prepo;
	
	public String huhu() {
		String txt="sdf";
		return txt;
	}
	
	public Boolean createProject(String name) {
		Project temp = new Project(name);

		Transaction tx = db.beginTx();
		Prepo.save(temp);
		tx.success();
		tx.close();
		return true;
		
	}
}
