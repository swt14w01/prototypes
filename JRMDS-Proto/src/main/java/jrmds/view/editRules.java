package jrmds.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jrmds.controller.*;

@RestController
public class editRules {
	private Controller ctlr;
	
	@RequestMapping(value="/editRules")
	public String htmlOutput() {
		return ctlr.huhu();
	}
}
