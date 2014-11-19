package jrmds.controller.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public abstract class Component {
	@GraphId private Long id;

	private String refID;
	private List<String> Tags;
	private ComponentType type;
	
	Component() {
		//empty Constructor for no-args
	}
	
	Component(String refID, ComponentType type) {
		this.refID=refID;
		this.type=type;
		this.Tags = new ArrayList<String>();
	}
	
	public String getRefID() {
		return refID;
	}
	public void setRefID(String refID) {
		this.refID=refID;
	}
	public ComponentType getType() {
		return type;
	}
	public void setType(ComponentType type) {
		this.type=type;
	}
	public List<String> getTags() {
		return Tags;
	}
	public void setTags(List<String> Tags) {
		
	}
	
	//diese Methoden sind Platzhalter, damit Component Objekte zu den jeweiligen Objekten konvertiert werden können
	public String getDescription() {
		return "NA";
	}
	public String getCypher() {
		return "NA";
	}
	public Set<Parameter> getParameters() {
		return null;
	}
	public String getSeverity() {
		return "NA";
	}
}
