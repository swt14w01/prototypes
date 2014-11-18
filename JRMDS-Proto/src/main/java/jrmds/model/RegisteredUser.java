package jrmds.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class RegisteredUser {
	@GraphId private Long id;
	private String forename;
	private String surname;
	
	RegisteredUser(String f, String s) {
		forename=f;
		surname=s;
	}
	
	public String getForename() {
		return forename;
	}
	public String getSurname() {
		return surname;
	}
}
