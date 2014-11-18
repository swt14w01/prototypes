package jrmds.controller.model;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Component {
	@GraphId private Long id;

	private String RefID;
	private List<String> Tags;
	
	Component(String RefID) {
		this.RefID=RefID;
		this.Tags = new ArrayList<String>();
	}
	
	public String getRefID() {
		return RefID;
	}
	public List<String> getTags() {
		return Tags;
	}
}
