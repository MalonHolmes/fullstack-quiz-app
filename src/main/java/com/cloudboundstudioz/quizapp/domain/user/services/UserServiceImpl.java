package com.cloudboundstudioz.quizapp.domain.user.services;

import com.cloudboundstudioz.quizapp.domain.core.exceptions.ResourceCreationException;
import com.cloudboundstudioz.quizapp.domain.core.exceptions.ResourceNotFoundException;
import com.cloudboundstudioz.quizapp.domain.user.models.User;
import com.cloudboundstudioz.quizapp.domain.user.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * When you annotate a class with @Service, Spring's component scanning mechanism
 * will detect it and automatically register it as a Spring bean in the application context.
 * This means that the class can be injected and used by other Spring-managed components,
 * such as controllers, other services, or repositories.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method handles the creation of our entities
     * and places them in our database.
     *
     * First, checks if user with username already exists, if so, throw exception.
     * If it doesnt already exist, saves/persists it to the database.
     * Then return user
     *
     * @param user
     * @return
     * @throws ResourceCreationException
     */
    @Override
    public User create(User user) throws ResourceCreationException {
        Optional<User> optional = userRepository.findByUsername(user.getUsername());
        if(optional.isPresent())
            throw new ResourceCreationException("User with username already exists: " + user.getUsername());
        user = userRepository.save(user);
        return user;
    }

    /**
     * Gets the repo to find a user by the id,
     * then returns the user if there. if user not there
     * then return a 404 not found error.
     * @param id
     * @throws ResourceNotFoundException
     */
    @Override
    public User getById(Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No user with id: " + id));
        return user;
    }

    @Override
    public User getByUsername(String username) throws ResourceNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("No user with username: " + username));
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User userDetail) throws ResourceNotFoundException {
        User user = getById(id);
        user.setUsername(userDetail.getUsername());
        user.setPassword(userDetail.getPassword());
        user = userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        User user = getById(id);
        userRepository.delete(user);
    }
}
