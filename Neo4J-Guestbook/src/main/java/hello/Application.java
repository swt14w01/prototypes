package hello;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
//@EnableNeo4jRepositories
//@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@ComponentScan
public class Application extends Neo4jConfiguration {
	public GraphDatabaseService repo;
	public Application() {
		repo = new SpringRestGraphDatabase("http://[::]:7474/db/data");
		setBasePackage("hello");
	}

	@Bean(destroyMethod = "shutdown")
	/*public GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory().SpringRestGraphDatabase("target/hello.db");
	}*/
	public GraphDatabaseService graphDatabaseService() {
		return repo;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
