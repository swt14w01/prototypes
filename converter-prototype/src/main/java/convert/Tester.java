package convert;
import java.io.File; 
import java.util.List;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

class Tester{
	 
	

	public static void main(String [ ] args) throws Exception
	{
		List<Rules> rules = new ArrayList<Rules>();
	
		Rules rule1 = new Rules();
		
		rule1.setId( "John Peel" );
		rule1.setDescription( "John Peel" );
		rule1.setCypher( "John Peel" );
		
		Constraint rule2 = new Constraint();
		
		rule2.setId( "John Peel2" );
		rule2.setDescription( "John Peel2" );
		rule2.setCypher( "John Peel2" );
		
		Concept rule3 = new Concept();
		
		
		Concept rule4 = new Concept();
		
		
		Concept rule5 = new Concept();
	
		
		rule3.setConcept(rule4);
		rule3.setConcept(rule5);
		
		Group rule6 = new Group();
		Group rule7 = new Group();
		Group rule8 = new Group();
		rule6.setGroup(rule7);
		rule6.setGroup(rule8);
		
		
		rules.add(rule1);
		rules.add(rule2);
		rules.add(rule3);
		rules.add(rule6);
		
		Converter convert = new Converter();
		//Konvertierung mit prototypischen Klassen Concept, Constraint..
		convert.plaintoxml(rules);
	   
	  
	 File file = new File("tester.xml");

	 convert.xmltoplain(file);
	}
 
	 
	 
}



	         