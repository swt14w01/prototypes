package jrmds.controller;

import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
import org.springframework.stereotype.Controller;

import java.util.Set;
import java.util.HashSet;

import jrmds.controller.model.*;
import jrmds.user.model.*;

@Controller
public class JrmdsMainController {
	@Autowired
	private SpringRestGraphDatabase db;
	@Autowired
	private RuleRepository ruleRepository;
	@Autowired
	private ProjectRepository projectRepository;

	
	// GETTER AND SETTER
	public Project getProject(String pname) {
		Project temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = projectRepository.findByName(pname);
			tx.success();
		}
		return temp;
	}

	public Constraint getConstraint(Project project, String refID) {
		Constraint result;
		try (Transaction tx = db.beginTx()) {
			result = new Constraint(ruleRepository.findByRefID(refID, ComponentType.CONCEPT));
			tx.success();
		}
		return result;
	}

	public Concept getConcept(Project project, String RefID) {
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = ruleRepository.findByRefID(RefID, ComponentType.CONCEPT);
			tx.success();
		}
		Concept temp2 = new Concept(temp);
		return temp2;
	}

	public Group getGroup(Project project, String RefID) {
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = ruleRepository.findByRefID(RefID, ComponentType.GROUP);
			tx.success();
		}
		Group temp2 = new Group(temp);
		return temp2;
	}

	public QueryTemplate getTemplate(Project project, String RefID) {
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = ruleRepository.findByRefID(RefID, ComponentType.TEMPLATE);
			tx.success();
		}
		QueryTemplate temp2 = new QueryTemplate(temp);
		return temp2;
	}

	public Component getComponent(Project project, Component cmpt) {
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = ruleRepository.findByRefID(cmpt.getRefID(), cmpt.getType());
			tx.success();
		}
		return temp;
	}

	public Set<Project> getAllProjects() {
		Set<Project> allprojects = new HashSet<Project>();
		for (Project node : projectRepository.findAll()) {
			allprojects.add(node);
		}
		return allprojects;
	}

	public Set<RegisteredUser> getProjectUsers(Project project) {
		Set<RegisteredUser> temp = new HashSet<RegisteredUser>();

		return temp;
	}

	public boolean saveProject(Project project) {
		Project temp = getProject(project.getName());
		if (temp == null) {
			// create a new one
			try (Transaction tx = db.beginTx()) {
				projectRepository.save(project);
				tx.success();
			}
			return true;
		} else {
			// update existing one
			try (Transaction tx = db.beginTx()) {
				temp.copyProject(project);
				projectRepository.save(project);
				tx.success();
			}
			return false;
		}
	}

	public boolean saveComponent(Project project, Component cmpt) {
		Component temp = getComponent(project, cmpt);
		if (temp == null) {
			try (Transaction tx = db.beginTx()) {
				ruleRepository.save(cmpt);
				tx.success();
			}
			return true;
		} else {
			// update bestehenden Eintrag
			try (Transaction tx = db.beginTx()) {
				temp.copy(cmpt);
				ruleRepository.save(temp);
				tx.success();
			}
			return false;
		}
	}

	public boolean deleteProject(Project project) {
		boolean booli = false;
		try (Transaction tx = db.beginTx()) {
			projectRepository.delete(project.getId());
			if (!projectRepository.exists(project.getId()))
				booli = true;
			tx.success();
		}
		return booli;
	}

	public boolean deleteComponent(Project project, Component cmpt) {
		boolean booli = false;
		try (Transaction tx = db.beginTx()) {
			ruleRepository.delete(cmpt.getId());
			if (!ruleRepository.exists(cmpt.getId()))
				booli = true;
			tx.success();
		}
		return booli;
		// what happens, if relations still persist from and to this component?
	}

	public Set<Component> referecedBy(Project project, Component cmpt) {
		// find all Backlinks to this component (which COmponent is using THIS
		// as dependency
		Set<Component> temp = new HashSet<Component>();

		return temp;
	}

	public Set<Component> getGroupComponents(Project project, Group g) {
		// returns a Set of EVERY Rule, to generate a Set of Components for XML
		// output
		Set<Component> temp = null;

		return temp;
	}

	public Set<Component> getProjectComponents(Project project) {
		// returns a Set of all Components of a single Project
		Set<Component> temp = null;

		return temp;
	}

	public boolean addComponentToProject(Project project, Component cmpt) {
		// check wether the component is already linked or not
		// Query for releation CONTAINS
		return true;
	}

	public boolean addComponentReference(Project project, Component src,
			Component dest) {
		// adds a DEPENDSON relation and checks for possible cycles
		// Checks if relation is legit, only Groups can reference another
		// groups, only Concepts and templataes can use Templates....

		return true;
	}

}
