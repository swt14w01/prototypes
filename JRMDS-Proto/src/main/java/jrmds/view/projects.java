package jrmds.view;

import jrmds.controller.JRMDS;
import jrmds.controller.model.Project;

import org.neo4j.graphdb.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


public class projects {
	
	@Autowired
	private JRMDS ctlr;

	@RequestMapping(value="/projects")
	public String htmlOutput(){
		
		List<Project> projectlist = new ArrayList<Project>();
		projectlist = ctlr.getAllProjects();
		for(Project project :projectlist){
			//print project.getName(); project.getDescription(); project.getProjectleader();	
		}
		
		return "";
	}
	
	
	
	
}
