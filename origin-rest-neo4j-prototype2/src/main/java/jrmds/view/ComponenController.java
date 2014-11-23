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
	private JrmdsMainController controller;
	@Autowired
	private UserManagement usr;
	
	@RequestMapping(value="/editRules")
	public String htmlRules() {
		String temp="";

		//Ausgeben des aktuellen Inhaltes:
		Constraint foo = controller.getConstraint(null, null);
		
		//suche alle Parameter zusammen
		Set<Parameter> bar = foo.getParameters();
	
		Iterator<Parameter> iter = bar.iterator();
		while (iter.hasNext()) {
			temp+=iter.next().getName();
		}
		
		//Suche alle Dependencies (also Rules, von denen diese Rule hier abhängt) ... ist in dem Objekt drin, Set DEPENDSON;
		
		//welche Rules hängen von dieser ab... referencedBy()
		
		return temp;
	}
	
	@RequestMapping(value="/editGroup")
	public String htmlGroup() {
		
		
		return "";
	}
	
	@RequestMapping(value="/editTemplate")
	public String htmlTemplate() {
		
		
		return "";
	}
}
