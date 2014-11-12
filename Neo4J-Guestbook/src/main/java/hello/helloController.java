package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
	
	@RequestMapping(value="/hello",method={RequestMethod.POST, RequestMethod.GET})
	public String hello(
			@RequestParam(required=false, defaultValue="test") String name,
			@RequestParam(required=true) String action) {
		
		String temp=action+name;
	
		temp+="<html><body><p><form action='./hello?action=save' method='POST'><input type='text' name='name'><input type='submit' value='save' class='Button'></form></p></body></html>";
		
		return temp;
	}
}
