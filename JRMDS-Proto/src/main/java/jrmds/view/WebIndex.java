package jrmds.view;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebIndex {

	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
}
