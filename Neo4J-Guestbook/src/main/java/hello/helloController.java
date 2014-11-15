package hello;

import org.neo4j.graphdb.Transaction;
import org.neo4j.rest.graphdb.RestGraphDatabase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;


@RestController
public class helloController {
	
	@Autowired
	private PersonRepository pipapo;
	
	
	@RequestMapping(value="/hello",method={RequestMethod.POST, RequestMethod.GET})
	public String hello(
			@RequestParam(required=false, defaultValue="test") String name,
			@RequestParam(required=true) String action) {
		
		String temp="-"+action+"-";
		if (action.equals("start")) {
			temp+="<html><body><p><form action='./hello?action=save' method='POST'><input type='text' name='name'><input type='submit' value='save' class='Button'></form></p></body></html>";
		} else {
			Person blubb = new Person();
			blubb.setFirstName(name);
			blubb.setLastName(action);
			temp+=name;
			
			Transaction tx=Application.repo.beginTx();
			pipapo.save(blubb);
			tx.success();
			tx.close();
			
		}
		return temp;
	}
}
