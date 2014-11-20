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
<<<<<<< HEAD
	
	@SuppressWarnings("null")
=======
	public Constraint getConstraint(String RefID){
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = Rrepo.findByRefID(RefID,ComponentType.CONCEPT);
			tx.success();
		}
		Constraint temp2 = new Constraint(temp);
		return temp2;
	}
	public Concept getConcept(String RefID){
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = Rrepo.findByRefID(RefID,ComponentType.CONCEPT);
			tx.success();
		}
		Concept temp2 = new Concept(temp);
		return temp2;
	}
	public Group getGroup(String RefID){
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = Rrepo.findByRefID(RefID,ComponentType.GROUP);
			tx.success();
		}
		Group temp2 = new Group(temp);
		return temp2;
	}
	public QueryTemplate getTemplate(String RefID){
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = Rrepo.findByRefID(RefID,ComponentType.TEMPLATE);
			tx.success();
		}
		QueryTemplate temp2 = new QueryTemplate(temp);
		return temp2;
	}
	public boolean existsComponent(Component cmpt) {
		Component temp=null;
		try (Transaction tx = db.beginTx()) {
			temp = Rrepo.findByRefID(cmpt.getRefID(),cmpt.getType());
			tx.success();
		}
		if (temp==null) return false;
		return true;
	}
>>>>>>> e9cc16352cfb1d52c9e2b567eae751cfce746c63
	public List<Project> getAllProjects(){
		List<Project> allprojects = new ArrayList<Project>();
		for(Project node : Prepo.findAll()) { 
			allprojects.add(node);
		}
		return allprojects;
	}
	public boolean createProject(Project p) {
		if (getProject(p.getName())==null) {
			try (Transaction tx = db.beginTx()) {
				Prepo.save(p);
				tx.success();
			}
			return true;
		} else {
			return false;
		}	
	}
	public boolean createComponent(Component cmpt) {
		if (!existsComponent(cmpt)) {
			try (Transaction tx=db.beginTx()) {
				Rrepo.save(cmpt);
				tx.success();
			}
			return true;
		}
		return false;
	}
	
}
