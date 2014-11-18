package jrmds.view;

import jrmds.controller.JRMDS;
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
		
		List<Node> projectlist = new ArrayList<Node>();
		projectlist = ctlr.getAllProjects();
		for(Node project :projectlist){
			//print project.getName(); project.getDescription(); project.getProjectleader();	
		}
		
		return "";
	}
	
	
	
	
}
