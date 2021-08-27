package org.educationfree.schoollibweb.service.authentication;

import org.educationfree.schoollibweb.model.authentication.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
}
