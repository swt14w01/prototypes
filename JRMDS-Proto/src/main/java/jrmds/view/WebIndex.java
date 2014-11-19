package jrmds.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebIndex {

	@RequestMapping(value="/")
	public String index() {
		return "redirect:/index";
	}
}
