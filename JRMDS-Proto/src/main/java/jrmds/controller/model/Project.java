package jrmds.controller.model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.Fetch;

@NodeEntity
public class Project {
	@GraphId private Long id;
	private String name;
	private List<String> externalRepos;
	
	public Project() {
		//empty Constructor for Hibernate
	}
	
	public Project(String name) {
		this.name=name;
		externalRepos=new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	public List<String> getExternalRepos() {
		return externalRepos;
	}
	
	public boolean equals(Project p) {
		if (p.id.equals(this.id)) {
			return true;
		} else {
			return false;
		}
	}
	public int hashCode() {
		return this.id.intValue();
	}
	public String toString() {
		return name;
	}
	
}
