package convert;

import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlElements; 
import javax.xml.bind.annotation.XmlRootElement;  
import javax.xml.bind.annotation.XmlType; 
import javax.xml.bind.annotation.XmlAttribute; 
import javax.xml.bind.annotation.XmlElementWrapper; 
import javax.xml.bind.annotation.XmlList;

import java.util.*;

@XmlRootElement(name ="jqa:jqassistant-rules")

public class Component {

	
private	List<Rules> rules = new ArrayList<Rules>();
	@XmlAttribute
	private String add =" xmlns:jqa='http://www.buschmais.com/jqassistant/core/analysis/rules/schema/v1.0'";
	
	public String getAdd(){
		return this.add;
		
	}
	


	
public void setList(List<Rules> rules){
	this.rules=rules;
}

@XmlElements({
@XmlElement(name = "constraint", type=Constraint.class),
@XmlElement(name = "concept", type=Concept.class),
@XmlElement(name = "group", type=Group.class),
@XmlElement(name = "rules", type=Rules.class)})
public List<Rules> getList(){
	return rules;
}

}
