package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {
    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate birthday;
    private final int numberOfPosts;

    public ForumUser(final int userId, final String username, final char sex, final LocalDate birthday,
                     final int numberOfPosts) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return userId == forumUser.userId && sex == forumUser.sex && numberOfPosts == forumUser.numberOfPosts && Objects.equals(username, forumUser.username) && Objects.equals(birthday, forumUser.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, sex, birthday, numberOfPosts);
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
