package com.kodilla.good.patterns.strategy.social;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTestSuite {
    @Test
    void testDefaultSharingStrategies() {
        User marc = new Millenials("Marc Holland");
        User john = new YGeneration("John Doe");
        User kate = new ZGeneration("Kate Riddle");

        String marcShouldShare = marc.sharePost();
        System.out.println("Marc sharing: " + marcShouldShare);
        String johnShouldShare = john.sharePost();
        System.out.println("John sharing: " + johnShouldShare);
        String kateShouldShare = kate.sharePost();
        System.out.println("Kate sharing: " + kateShouldShare);

        assertEquals("[Facebook] post on facebook", marcShouldShare);
        assertEquals("[Twitter] post on Twitter", johnShouldShare);
        assertEquals("[Snapchat] post on Snapchat", kateShouldShare);
    }

    @Test
    void testIndividualSharingStrategy() {
        User marc = new Millenials("Marc Holland");

        String marcShouldShare = marc.sharePost();
        System.out.println("Marc sharing: " + marcShouldShare);
        marc.setSocialPublisher(new SnapchatPublisher());
        marcShouldShare = marc.sharePost();
        System.out.println("Marc new sharing: " + marcShouldShare);

        assertEquals("[Snapchat] post on Snapchat", marcShouldShare);
    }
}
