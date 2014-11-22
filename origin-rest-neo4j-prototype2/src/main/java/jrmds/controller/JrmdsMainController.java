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

	// GETTER AND SETTER FOR ALL REPOS
	public Project getProject(String projectName) {
		Project result;
		try (Transaction tx = db.beginTx()) {
			result = projectRepository.findByName(projectName);
			tx.success();
		}
		return result;
	}

	public Constraint getConstraint(Project project, String refID) {
		Constraint result;
		try (Transaction tx = db.beginTx()) {
			result = new Constraint(ruleRepository.findByRefID(refID,
					ComponentType.CONCEPT));
			tx.success();
		}
		return result;
	}

	public Concept getConcept(Project project, String refID) {
		Concept result;
		try (Transaction tx = db.beginTx()) {
			result = new Concept(ruleRepository.findByRefID(refID,
					ComponentType.CONCEPT));
			tx.success();
		}
		return result;
	}

	public Group getGroup(Project project, String refID) {
		Group result;
		try (Transaction tx = db.beginTx()) {
			result = new Group(ruleRepository.findByRefID(refID,
					ComponentType.GROUP));
			tx.success();
		}
		return result;
	}

	public QueryTemplate getTemplate(Project project, String refID) {
		QueryTemplate result;
		try (Transaction tx = db.beginTx()) {
			result = new QueryTemplate(ruleRepository.findByRefID(refID,
					ComponentType.TEMPLATE));
			tx.success();
		}
		return result;
	}

	public Component getComponent(Project project, Component component) {
		Component temp = null;
		try (Transaction tx = db.beginTx()) {
			temp = ruleRepository.findByRefID(component.getRefID(), component.getType());
			tx.success();
		}
		return temp;
	}

	public Set<Project> getAllProjects() {
		Set<Project> allProjects = new HashSet<Project>();
		for (Project node : projectRepository.findAll()) {
			allProjects.add(node);
		}
		return allProjects;
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

	public boolean saveComponent(Project project, Component component) {
		Component temp = getComponent(project, component);
		if (temp == null) {
			try (Transaction tx = db.beginTx()) {
				ruleRepository.save(component);
				tx.success();
			}
			return true;
		} else {
			// update bestehenden Eintrag
			try (Transaction tx = db.beginTx()) {
				temp.copy(component);
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

	public boolean deleteComponent(Project project, Component component) {
		boolean booli = false;
		try (Transaction tx = db.beginTx()) {
			ruleRepository.delete(component.getId());
			if (!ruleRepository.exists(component.getId()))
				booli = true;
			tx.success();
		}
		return booli;
		// what happens, if relations still persist from and to this component?
	}

	public Set<Component> referecedBy(Project project, Component component) {
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

	public boolean addComponentToProject(Project project, Component component) {
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
