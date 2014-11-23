package jrmds.view;

import java.util.ArrayList;
import java.util.List;

import jrmds.controller.JrmdsMainController;
import jrmds.controller.RuleRepository;
import jrmds.controller.model.Component;
import jrmds.user.UserManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
	@Autowired
	private JrmdsMainController controller;
	@Autowired
	private UserManagement usr;
	@Autowired
	public RuleRepository ruleRepository;

	List<Component> autocompleteList;

	@RequestMapping(value = "/getAutoCompleteSuggestions", method = RequestMethod.GET)
	public @ResponseBody List<Component> getAutoCompleteSuggestions(@RequestParam String tagName) {
		autocompleteList = new ArrayList<Component>();
		for (Component person : controller.getComponents()) {
			if(person.getRefID().toLowerCase().contains(tagName))
			
			autocompleteList.add(person);
		}

		return autocompleteList;

	}

	
/*	@RequestMapping(value="/projectOverview", method = )*/
	
	
	
}
