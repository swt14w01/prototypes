package jrmds.controller;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.tooling.GlobalGraphOperations;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.*;

import jrmds.controller.model.*;

@Controller
public class JRMDS {
	@Autowired
	private GraphDatabaseService db;
	@Autowired
	private RuleRepository Rrepo;
	@Autowired
	private ProjectRepository Prepo;
	
	
	public Project getProject(String pname) {
		Project temp=null;
		try (Transaction tx = db.beginTx()) {
			temp=Prepo.findByName(pname);
			tx.success();
		}
		return temp;
	}
	
	public List<Project> getAllProjects(){
		List<Project> allprojects = new ArrayList<Project>();
		for(Project node : Prepo.findAll()) { 
			allprojects.add(node);
		}
		return allprojects;
	}
	
	public boolean createProject(String name) {
		if (getProject(name)==null) {
			try (Transaction tx = db.beginTx()) {
				Project temp = new Project(name);
				Prepo.save(temp);
				tx.success();
			}
			return true;
		} else {
			return false;
		}
		
	}
}
