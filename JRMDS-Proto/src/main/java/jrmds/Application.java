package jrmds;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;

@Configuration
@EnableAutoConfiguration
@EnableNeo4jRepositories(basePackages = "jrmds")
@ComponentScan
public class Application extends Neo4jConfiguration {
	
	public Application() {
		setBasePackage("jrmds");
	}

	@Bean
	public GraphDatabaseService graphDatabaseService() {
		return new SpringRestGraphDatabase("http://[::1]:7474/db/data");
	}
    
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
