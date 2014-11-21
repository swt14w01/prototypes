package jrmds.view;

import jrmds.controller.JrmdsMainController;
import jrmds.controller.model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.HashSet;

@RestController
public class ProjectController {
	@Autowired
	private JrmdsMainController ctlr;

	@RequestMapping(value="/projects")
	public String htmlOutput(){
		String temp="";
		Set<Project> projectlist = new HashSet<Project>();
		projectlist = ctlr.getAllProjects();
		for(Project project :projectlist){
			temp+=project.getName(); 
		}
		
		return temp;
	}
	
	
	
	
}
