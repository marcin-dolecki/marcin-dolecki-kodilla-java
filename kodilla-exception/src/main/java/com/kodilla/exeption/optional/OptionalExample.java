package com.kodilla.exeption.optional;

import com.kodilla.exeption.nullpointer.User;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        User user = new User("user1");
        /* null user to see the magic of Optional */
//        User user = null;

        Optional<User> optionalUser = Optional.ofNullable(user);

        /* orElse */
//        String userName = optionalUser.orElse(new User("")).getName();
//        System.out.println(userName);

        /* ifPresent */
        optionalUser.ifPresent(u -> System.out.println(u.getName()));
    }
}
