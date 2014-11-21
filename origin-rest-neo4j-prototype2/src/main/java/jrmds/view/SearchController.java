package jrmds.view;

import java.util.ArrayList;
import java.util.List;

import jrmds.Person;
import jrmds.PersonRepository;
import jrmds.controller.JrmdsMainController;
import jrmds.controller.model.Tag;
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
	private JrmdsMainController jrmdsMainController;
	@Autowired
	private UserManagement usr;
	@Autowired
	public PersonRepository personRepository;

	List<Person> personsList;

	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody List<Person> getTags(@RequestParam String tagName) {
		personsList = new ArrayList<Person>();
		for (Person person : personRepository.findAll()) {
			personsList.add(person);
		}

		return simulateSearchResult(tagName);

	}

	private List<Person> simulateSearchResult(String tagName) {

		List<Person> result = new ArrayList<Person>();

		// iterate a list and filter by tagName
		for (Person person : personsList) {
			if (person.getName().contains(tagName)) {
				result.add(person);
			}
		}

		return result;
	}
}
