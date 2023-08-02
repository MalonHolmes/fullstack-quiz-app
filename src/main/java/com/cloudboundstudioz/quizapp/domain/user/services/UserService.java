package com.cloudboundstudioz.quizapp.domain.user.services;

import com.cloudboundstudioz.quizapp.domain.core.exceptions.ResourceCreationException;
import com.cloudboundstudioz.quizapp.domain.core.exceptions.ResourceNotFoundException;
import com.cloudboundstudioz.quizapp.domain.user.models.User;

import java.util.List;

public interface UserService {
    User create(User user) throws ResourceCreationException;
    User getById(Long id) throws ResourceNotFoundException;
    User getByUsername(String username) throws ResourceNotFoundException;
    List<User> getAll();
    User update(Long id, User userDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
