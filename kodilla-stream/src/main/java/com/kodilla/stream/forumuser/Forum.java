package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum() {
        theForumUserList.add(new ForumUser(1, "user1", 'M', LocalDate.of(1991,1,1), 1));
        theForumUserList.add(new ForumUser(2, "user2", 'M', LocalDate.of(1992,1,1), 0));
        theForumUserList.add(new ForumUser(3, "user3", 'M', LocalDate.of(1993,1,1), 5));
        theForumUserList.add(new ForumUser(4, "user4", 'M', LocalDate.of(1994,1,1), 0));
        theForumUserList.add(new ForumUser(5, "user5", 'F', LocalDate.of(1991,1,1), 1));
        theForumUserList.add(new ForumUser(6, "user6", 'F', LocalDate.of(1992,1,1), 0));
        theForumUserList.add(new ForumUser(7, "user7", 'F', LocalDate.of(1993,1,1), 5));
        theForumUserList.add(new ForumUser(8, "user8", 'F', LocalDate.of(1994,1,1), 0));
        theForumUserList.add(new ForumUser(9, "user9", 'M', LocalDate.of(2015,1,1), 1));
        theForumUserList.add(new ForumUser(10, "user10", 'M', LocalDate.of(2016,1,1), 0));
        theForumUserList.add(new ForumUser(11, "user11", 'M', LocalDate.of(2017,1,1), 5));
        theForumUserList.add(new ForumUser(12, "user12", 'M', LocalDate.of(2018,1,1), 0));
        theForumUserList.add(new ForumUser(13, "user13", 'F', LocalDate.of(2019,1,1), 1));
        theForumUserList.add(new ForumUser(14, "user14", 'F', LocalDate.of(2020,1,1), 0));
        theForumUserList.add(new ForumUser(15, "user15", 'F', LocalDate.of(2021,1,1), 5));
        theForumUserList.add(new ForumUser(16, "user16", 'F', LocalDate.of(2022,1,1), 0));
    }

    public List<ForumUser> getUserList() {
        return theForumUserList;
    }
}
