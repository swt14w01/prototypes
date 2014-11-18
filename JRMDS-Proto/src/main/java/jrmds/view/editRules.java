package jrmds.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class editRules {

	@RequestMapping(value="/editRules")
	public String htmlOutput() {
		String output="";
		return output;
	}
}
