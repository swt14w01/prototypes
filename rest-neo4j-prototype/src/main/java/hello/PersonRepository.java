package hello;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends CrudRepository<Person, String> {

    Person findByName(String firstname);

}