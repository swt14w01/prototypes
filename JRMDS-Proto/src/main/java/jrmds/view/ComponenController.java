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
		
		//Ausgeben des aktuellen Inhaltes:
		Constraint foo = ctlr.getConstraint(null);
		
		//suche alle Parameter zusammen
		Set<Parameter> bar = foo.getParameters();
	
		Iterator<Parameter> iter = bar.iterator();
		while (iter.hasNext()) {
			temp+=iter.next().getName();
		}
		
		//Suche alle Dependencies (also Rules, von denen diese Rule hier abhängt)
		
		return temp;
	}
}
