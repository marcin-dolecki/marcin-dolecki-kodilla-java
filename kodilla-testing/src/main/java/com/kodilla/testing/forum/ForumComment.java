package com.kodilla.testing.forum;

import java.util.Objects;

public class ForumComment {
    private final ForumPost forumPost;
    private final String commentBody;
    private final String author;

    public ForumComment(ForumPost forumPost, String commentBody, String author) {
        this.forumPost = forumPost;
        this.commentBody = commentBody;
        this.author = author;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getAuthor() {
        return author;
    }

    public String getCommentBody() {
        return commentBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumComment that = (ForumComment) o;
        return Objects.equals(forumPost, that.forumPost) && Objects.equals(commentBody, that.commentBody) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forumPost, commentBody, author);
    }
}
