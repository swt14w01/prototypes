package jrmds.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jrmds.controller.*;
import jrmds.user.*;

@RestController
public class editRules {
	
	private JRMDS ctlr;
	private UserManagement usr;
	
	@RequestMapping(value="/editRules")
	public String htmlOutput() {
		String temp="";
		
		temp=ctlr.blubb();
		//if (ctlr.createProject("testproject")) temp+="Project_YES - ";
		//if (usr.createUser("Brain", "Power")) temp+="User_YES - ";
		
		
		return temp;
	}
}
