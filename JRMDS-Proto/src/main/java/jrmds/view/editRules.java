package jrmds.view;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jrmds.controller.*;
import jrmds.controller.model.*;
import jrmds.user.*;
import jrmds.user.model.*;

@RestController
public class editRules {
	@Autowired
	private JRMDS ctlr;
	@Autowired
	private UserManagement usr;
	
	@RequestMapping(value="/editRules")
	public String htmlOutput() {
		String temp="";
		
		if (ctlr.createProject("testproject01")) temp+="Project_YES - ";
		if (ctlr.createProject("testproject02")) temp+="Project_YES - ";
		if (usr.createUser("Brain", "Power")) temp+="User_YES - ";
		if (usr.userWorksOn(usr.getUser("Power"), ctlr.getProject("testproject01"))) temp+="WorksON_YES - ";
		if (usr.userWorksOn(usr.getUser("Power"), ctlr.getProject("testproject02"))) temp+="WorksON_YES - ";
		
		Iterator<Project> iter = usr.getUser("Power").getProjects().iterator();
		while (iter.hasNext()) {
			temp+=iter.next().toString();
		}
		
		return temp;
	}
}
