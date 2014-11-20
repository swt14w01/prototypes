package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;

@Configuration
@EnableAutoConfiguration
@EnableNeo4jRepositories(basePackages = "hello")
@ComponentScan
public class Application extends Neo4jConfiguration {
	public static GraphDatabaseService repo;
	
	public Application() {
		repo=new SpringRestGraphDatabase("http://[::1]:7474/db/data");
		setBasePackage("hello");
	}

	@Bean
	public GraphDatabaseService graphDatabaseService() {
		return repo;
	}
	
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}