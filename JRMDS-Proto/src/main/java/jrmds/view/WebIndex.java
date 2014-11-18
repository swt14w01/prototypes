package jrmds.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebIndex {

	@RequestMapping(value="/",method={RequestMethod.POST, RequestMethod.GET})
	public String index(
			@RequestParam(required=false, defaultValue="test") String name,
			@RequestParam(required=true) String action) {
		return "index";
	}
}
