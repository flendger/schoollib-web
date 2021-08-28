package org.educationfree.schoollibweb.service.authentication;

import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.model.authentication.User;
import org.educationfree.schoollibweb.repository.authentication.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
