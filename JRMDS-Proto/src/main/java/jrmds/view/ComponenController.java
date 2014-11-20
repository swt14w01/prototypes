package jrmds.view;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jrmds.controller.*;
import jrmds.controller.model.*;
import jrmds.user.*;
import jrmds.user.model.*;

@RestController
public class ComponenController {
	@Autowired
	private JRMDS ctlr;
	@Autowired
	private UserManagement usr;
	
	@RequestMapping(value="/editRules")
	public String htmlRules() {
		String temp="";
		
<<<<<<< HEAD
		if (ctlr.createProject("testproject01")) temp+="Project_YES - ";
		if (ctlr.createProject("testproject02")) temp+="Project_YES - ";

		if (usr.createUser("Brain", "Power", "What")) temp+="User_YES - ";
		//if (usr.userWorksOn("Power", "testproject01")) temp+="WorksON_YES - ";;
		//if (usr.userWorksOn("Power", "testproject02")) temp+="WorksON_YES - ";;

		//if (usr.createUser("Brain", "Power")) temp+="User_YES - ";
		if (usr.userWorksOn(usr.getUser("Power"), ctlr.getProject("testproject01"))) temp+="WorksON_YES - ";
		if (usr.userWorksOn(usr.getUser("Power"), ctlr.getProject("testproject02"))) temp+="WorksON_YES - ";
=======
		//Ausgeben des aktuellen Inhaltes:
		Constraint foo = ctlr.getConstraint(null);
>>>>>>> e9cc16352cfb1d52c9e2b567eae751cfce746c63
		
		//suche alle Parameter zusammen
		Set<Parameter> bar = foo.getParameters();
	
		Iterator<Parameter> iter = bar.iterator();
		while (iter.hasNext()) {
<<<<<<< HEAD
			temp+=iter.next().toString();
		}
=======
			temp+=iter.next().getName();
		}
>>>>>>> e9cc16352cfb1d52c9e2b567eae751cfce746c63
		
		//Suche alle Dependencies (also Rules, von denen diese Rule hier abhängt)
		
		return temp;
	}
}
