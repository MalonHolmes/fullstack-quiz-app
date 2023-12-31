package com.cloudboundstudioz.quizapp.domain.user.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * User Model Class:
 *
 * Representing the User in the app that
 * will be taking the quiz.
 * Each user has an id, username, and password.
 */
@Entity // java persistence api, allows java to save this object to our database
@NoArgsConstructor // Default, Non argument constructor, generated by Lombok
@RequiredArgsConstructor // parameterized constructor, tells spring to generate a constructor with the annotated variables marked @NonNull
@Data // generate the getters and setters
@Table(name="api_user")
public class User {

    @Id // tells spring that this is the unique identifier for the database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells spring to generate the value for it based on the strategy
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    public Quiz takeQuiz(){
        return null;
    }

    public String toString() {
        return String.format("%d %s %s", id, username, password);
    }
}
