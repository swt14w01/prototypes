package convert;

import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.*;


class Concept extends Rules{
	
private List<Concept> concepts = new ArrayList<Concept>();


@XmlElement(name="concept")
public List<Concept> getConceptList(){
	return this.concepts;
}

public void setConcept(Concept concept){
	this.concepts.add(concept);
}
	
}
