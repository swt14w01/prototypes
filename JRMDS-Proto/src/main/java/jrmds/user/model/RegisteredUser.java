package jrmds.user.model;

import java.util.HashSet;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.Fetch;
import jrmds.controller.model.*;

@NodeEntity
public class RegisteredUser {
	@GraphId private Long id;
	private String forename;
	private String surname;
	@RelatedTo(type="WORKSON", direction=Direction.BOTH)
	private @Fetch Set<Project> worksOn;
	
	public RegisteredUser(String f, String s) {
		forename=f;
		surname=s;
	}
	
	public void worksWith(Project project) {
        if (worksOn == null) {
            worksOn = new HashSet<Project>();
        }
        worksOn.add(project);
    }
	
	public String getForename() {
		return forename;
	}
	public String getSurname() {
		return surname;
	}
}
