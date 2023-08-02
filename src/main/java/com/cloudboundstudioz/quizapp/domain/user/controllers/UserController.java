package com.cloudboundstudioz.quizapp.domain.user.controllers;

import com.cloudboundstudioz.quizapp.domain.user.models.User;
import com.cloudboundstudioz.quizapp.domain.user.services.UserService;
import com.cloudboundstudioz.quizapp.domain.user.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents the controller for my application.
 * The controller is responsible for handling every http request
 * that will occur during the course of my app (GET, POST, PUT, DELETE)
 *
 */
@RestController // Allows Spring to look in this class for URIs and URLs
@RequestMapping("/api/v1/users") // base route for our server requests
public class UserController {

    // inject service into our controller
    private UserService userService;

    /**
     * This constructor will create a new UserController
     * and make sure the required bean/object (UserServiceImpl in this case)
     * is injected
     * @param userService
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * This method will handle creating/POSTing a user in the system/database
     * by asking the service to create the user, then receive the user back from the service,
     * and then respond with that user and the http status code 201.
     *
     * @param user - @RequestBody will tell Spring to grab the data
     *             from the http request regardless of the format (JSON, XML, etc.)
     *             and put that data in this parameter
     * @return - the created user from the service and the http status code 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        user = userService.create(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id){
        User user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<User> getByUsername(@RequestParam String username){
        User user = userService.getByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User userDetail) {
        userDetail = userService.update(id, userDetail);
        return new ResponseEntity<>(userDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        userService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
