package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum theForum = new Forum();
        LocalDate today = LocalDate.now();
        LocalDate twentyYearLimit = today.minusYears(20);

        Map<Integer, ForumUser> theResultForumMap = theForum.getUserList().stream()
                .filter(user -> user.getSex() == 'M' && (user.getBirthday().isBefore(twentyYearLimit)
                        || user.getBirthday().equals(twentyYearLimit)) && user.getNumberOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        System.out.println("The result forum map:");
        System.out.println(theResultForumMap);
        
        System.out.println("\n# users: " + theResultForumMap.size());
        theResultForumMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
