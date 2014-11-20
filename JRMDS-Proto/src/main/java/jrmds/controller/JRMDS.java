package jrmds.controller;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Set;
import java.util.HashSet;

import jrmds.controller.model.*;
import jrmds.user.model.*;

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
	public Constraint getConstraint(Project p, String RefID){
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = Rrepo.findByRefID(RefID,ComponentType.CONCEPT);
			tx.success();
		}
		Constraint temp2 = new Constraint(temp);
		return temp2;
	}
	public Concept getConcept(Project p, String RefID){
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = Rrepo.findByRefID(RefID,ComponentType.CONCEPT);
			tx.success();
		}
		Concept temp2 = new Concept(temp);
		return temp2;
	}
	public Group getGroup(Project p, String RefID){
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = Rrepo.findByRefID(RefID,ComponentType.GROUP);
			tx.success();
		}
		Group temp2 = new Group(temp);
		return temp2;
	}
	public QueryTemplate getTemplate(Project p, String RefID){
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = Rrepo.findByRefID(RefID,ComponentType.TEMPLATE);
			tx.success();
		}
		QueryTemplate temp2 = new QueryTemplate(temp);
		return temp2;
	}
	public Component getComponent(Project p, Component cmpt) {
		Component temp=null;
		try (Transaction tx = db.beginTx()) {
			temp = Rrepo.findByRefID(cmpt.getRefID(),cmpt.getType());
			tx.success();
		}
		return temp;
	}
	public Set<Project> getAllProjects(){
		Set<Project> allprojects = new HashSet<Project>();
		for(Project node : Prepo.findAll()) { 
			allprojects.add(node);
		}
		return allprojects;
	}
	public Set<RegisteredUser> getProjectUsers(Project p) {
		Set<RegisteredUser> temp = new HashSet<RegisteredUser>();
		
		return temp;
	}
	public boolean saveProject(Project p) {
		Project temp = getProject(p.getName());
		if (temp == null) {
			//create a new one
			try (Transaction tx = db.beginTx()) {
				Prepo.save(p);
				tx.success();
			}
			return true;
		} else {
			//update existing one
			try (Transaction tx = db.beginTx()) {
				temp.copyProject(p);				
				Prepo.save(p);
				tx.success();
			}
			return false;
		}	
	}
	public boolean saveComponent(Project p, Component cmpt) {
		Component temp = getComponent(p, cmpt);
		if (temp == null) {
			try (Transaction tx=db.beginTx()) {
				Rrepo.save(cmpt);
				tx.success();
			}
			return true;
		} else {
			//update bestehenden Eintrag
			try (Transaction tx=db.beginTx()) {
				temp.copy(cmpt);
				Rrepo.save(temp);
				tx.success();
			}
			return false;
		}
	}
	public boolean deleteProject(Project p) {
		boolean booli=false;
		try (Transaction tx=db.beginTx()) {
			Prepo.delete(p.getId());
			if (!Prepo.exists(p.getId())) booli=true;
			tx.success();
		}
		return booli;
	}
	public boolean deleteComponent(Project p, Component cmpt) {
		boolean booli=false;
		try (Transaction tx=db.beginTx()) {
			Rrepo.delete(cmpt.getId());
			if (!Rrepo.exists(cmpt.getId())) booli=true;
			tx.success();
		}
		return booli;
		//what happens, if relations still persist from and to this component?
	}
	public Set<Component> referecedBy(Project p, Component cmpt) {
		//find all Backlinks to this component (which COmponent is using THIS as dependency
		Set<Component> temp = new HashSet<Component>();

		
		return temp;
	}
	public Set<Component> getGroupComponents(Project p, Group g) {
		//returns a Set of EVERY Rule, to generate a Set of Components for XML output
		Set<Component> temp = null;
		
		return temp;
	}
	public Set<Component> getProjectComponents(Project p) {
		//returns a Set of all Components of a single Project
		Set<Component> temp = null;
		
		return temp;
	}
	public boolean addComponentToProject(Project p, Component cmpt) {
		//check wether the component is already linked or not
		//Query for releation CONTAINS
		return true;
	}
	public boolean addComponentReference(Project p, Component src, Component dest) {
		//adds a DEPENDSON relation and checks for possible cycles
		//Checks if relation is legit, only Groups can reference another groups, only Concepts and templataes can use Templates....
		
		
		return true;
	}
	
	
}
