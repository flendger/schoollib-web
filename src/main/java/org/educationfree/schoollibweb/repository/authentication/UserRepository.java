package org.educationfree.schoollibweb.repository.authentication;

import org.educationfree.schoollibweb.model.authentication.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUserName(String userName);
}
