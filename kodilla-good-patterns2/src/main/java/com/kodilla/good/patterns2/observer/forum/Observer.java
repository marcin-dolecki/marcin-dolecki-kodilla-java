package com.kodilla.good.patterns2.observer.forum;

public interface Observer {
    void update(ForumTopic forumTopic, String post);
}
