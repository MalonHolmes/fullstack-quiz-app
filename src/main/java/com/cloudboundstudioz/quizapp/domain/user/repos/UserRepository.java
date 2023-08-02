package com.cloudboundstudioz.quizapp.domain.user.repos;

import com.cloudboundstudioz.quizapp.domain.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository; // jparepository inherits from CRUD and adds a little more functionality

import java.util.Optional;

/**
 * This interface is our Data Access Object,
 * responsible for handling data access and database ops.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
