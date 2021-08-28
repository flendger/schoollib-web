package org.educationfree.schoollibweb.repository.authentication;

import org.educationfree.schoollibweb.model.authentication.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}