package jrmds.controller;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jrmds.controller.model.*;

@Controller
public class JRMDS {
	@Autowired
	private GraphDatabaseService db;
	@Autowired
	private RuleRepository Rrepo;
	@Autowired
	private ProjectRepository Prepo;

	public String blubb() {
		return "hio";
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
