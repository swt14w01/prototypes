package jrmds.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class WebIndex extends WebMvcConfigurerAdapter {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "redirect:/index2";
	}
}
