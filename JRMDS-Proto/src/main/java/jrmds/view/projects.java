package jrmds.view;

import jrmds.controller.JRMDS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class projects {
	
	@Autowired
	private JRMDS ctlr;

	@RequestMapping(value="/projects")
	public String htmlOutput(){
		/*List<Project> projectlist = clr.getAllProjects();
		
		for(Project project :projectlist){
			print project.getName(); project.getDescription(); project.getProjectleader();	
		}
		*/
		return "";
	}
	
	
	
	
}
