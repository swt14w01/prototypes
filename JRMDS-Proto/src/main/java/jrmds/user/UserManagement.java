package jrmds.user;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserManagement {
	@Autowired
	private GraphDatabaseService db;
	
	@Autowired
	private UserRepository Urepo;
}
