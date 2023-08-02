package com.cloudboundstudioz.quizapp.domain.user.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class constructorTest01 {

    @Test
    public void userTest01(){
        User user = new User("DemoUser", "Password");
        user.setId(1L);

        String expected = "1 DemoUser Password";
        String actual = user.toString();

        Assertions.assertEquals(expected, actual);
    }
}
