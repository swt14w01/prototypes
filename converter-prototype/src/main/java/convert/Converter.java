package convert;
import java.io.StringReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller; 

import java.util.*;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.util.List;




import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class Converter {

	List<Rules> rulesintern = new ArrayList<Rules>();
	
	public  void plaintoxml(List<Rules> rules){
	
		
		
	
		try{
			JAXBContext context;
			Component comp = new Component();
			comp.setList(rules);
			context = JAXBContext.newInstance( Component.class );
			Marshaller m = context.createMarshaller();
			m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
			m.marshal( comp, System.out );
			m.marshal(comp, new File("new.xml"));
			
			
		}
			catch (Exception e){
			
		}
		
		
	    }
		
		
		
	
	
	public  void xmltoplain(File file)throws JAXBException{
		System.out.println("XMLtoPlain");
		/*	
		 try {
			 
			
				JAXBContext jaxbContext = JAXBContext.newInstance(Component.class);
		 
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Component comp = (Component) jaxbUnmarshaller.unmarshal(file);
				System.out.println(comp); 
		 
			  } catch (JAXBException e) {
				e.printStackTrace();
			  }
	      		
			 System.out.println("XMLtoPlain");
				
	}
*/
	

	
	

}
	
}