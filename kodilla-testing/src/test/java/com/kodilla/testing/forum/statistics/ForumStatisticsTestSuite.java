package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ForumStatisticsTestSuite {
    Statistics statisticsMock;
    ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
        statisticsMock = mock(Statistics.class);
        forumStatistics = new ForumStatistics();
    }

    @Test
    void testWhenPostCountIsZero() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.userNames()).thenReturn(generateUserList(10));

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testWhenPostCountIsThousand() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);
        when(statisticsMock.userNames()).thenReturn(generateUserList(50));

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(20.0, forumStatistics.getAvgPostsPerUser());
    }

    @Test
    void testWhenCommentCountIsZero() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.userNames()).thenReturn(generateUserList(10));

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatistics.getAvgCommentsPerPost());
        assertEquals(0, forumStatistics.getAvgCommentsPerUser());
    }

    @Test
    void testWhenCommentsLessThanPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.userNames()).thenReturn(generateUserList(10));

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertTrue(forumStatistics.getAvgCommentsPerPost() < 1);
    }

    @Test
    void testWhenCommentsGreaterThanPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(150);
        when(statisticsMock.userNames()).thenReturn(generateUserList(10));

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertTrue(forumStatistics.getAvgCommentsPerPost() > 1);
    }

    @Test
    void testWhenUserCountIsZero() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(150);
        when(statisticsMock.userNames()).thenReturn(new ArrayList<>());

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatistics.getAvgPostsPerUser());
        assertEquals(0, forumStatistics.getAvgCommentsPerUser());
    }

    @Test
    void testWhenUserCountIsHundred() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);
        when(statisticsMock.userNames()).thenReturn(generateUserList(100));

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10.0, forumStatistics.getAvgPostsPerUser());
        assertEquals(5.0, forumStatistics.getAvgCommentsPerUser());
    }


    private List<String> generateUserList(int quantity) {
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            userList.add("User" + i);
        }
        return userList;
    }
}
