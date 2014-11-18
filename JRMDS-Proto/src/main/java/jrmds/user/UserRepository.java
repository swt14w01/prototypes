package jrmds.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jrmds.user.model.*;


@Repository
public interface UserRepository extends CrudRepository<RegisteredUser, Long> {
	RegisteredUser findByForename(String forename);
	RegisteredUser findBySurname(String surname);
	RegisteredUser findOne(Long id);
}