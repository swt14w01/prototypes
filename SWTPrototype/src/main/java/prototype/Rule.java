package prototype;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="jqassistant-rules",namespace="http://www.buschmais.com/jqassistant/core/analysis/rules/schema/v1.0")
public class Rule {
    
	@JsonProperty("concept")
    List<Concept> _concepts;
    
	@JsonProperty("constraint")
    List<Constraint> _constraints;
    
	
	List<Concept> getConcepts()
	{
		return _concepts;
	}
	
	@XmlElement(name="concept")
	void setConcepts(List<Concept> concepts)
	{
		_concepts = concepts;
	}

	List<Constraint> getConstraints()
	{
		return _constraints;
	}
	
	@XmlElement(name="constraint")
	void setConstraints(List<Constraint> constraints)
	{
		_constraints = constraints;
	}

    
}