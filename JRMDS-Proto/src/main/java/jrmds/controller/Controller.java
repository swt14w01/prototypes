package jrmds.controller;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;

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
}
