package jrmds.view;

import java.util.ArrayList;
import java.util.List;

import jrmds.Person;
import jrmds.PersonRepository;
import jrmds.controller.JrmdsMainController;
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
	public PersonRepository personRepository;

	List<Person> autocompleteList;

	@RequestMapping(value = "/getAutoCompleteSuggestions", method = RequestMethod.GET)
	public @ResponseBody List<Person> getAutoCompleteSuggestions(@RequestParam String tagName) {
		autocompleteList = new ArrayList<Person>();
		for (Person person : personRepository.findAll()) {
			if(person.getName().toLowerCase().contains(tagName))
			
			autocompleteList.add(person);
		}

		return autocompleteList;

	}

	
/*	@RequestMapping(value="/projectOverview", method = )*/
	
	
	
}
