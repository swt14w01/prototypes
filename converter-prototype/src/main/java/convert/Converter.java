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



//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.annotation.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.JsonMappingException;


public class Converter {
	Xmlview xmlview = new Xmlview();
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
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(false);
			DocumentBuilder db = dbf.newDocumentBuilder();
		 
			
			
			//xmlview.show();
			
		}
			catch (Exception e){
			
		}
		
		
	    }
		
		
		
	
	
	public  void xmltoplain(File file) throws Exception{
		System.out.println("XMLtoPlain");
			
		//import Error!
		/* JAXBContext jCtx = JAXBContext.newInstance(Component.class);
		Unmarshaller fromXml = jCtx.createUnmarshaller();
		Component rXml = (Component)fromXml.unmarshal( new FileReader("tester.xml"));

		//ObjectMapper mapper = new ObjectMapper();
       // System.out.println(mapper.writeValueAsString(rXml));*/
	      		
			 System.out.println("XMLtoPlain");
				
	}

	

	
	

}