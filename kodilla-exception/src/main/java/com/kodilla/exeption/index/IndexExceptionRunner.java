package com.kodilla.exeption.index;

import java.util.List;

public class IndexExceptionRunner {
    public static void main(String[] args) {
        VideoCollector videoCollector = new VideoCollector();
        List<String> collection = videoCollector.getCollection();

        if (collection.size() > 1) {
            String video = collection.get(0);
            System.out.println(video);

            String anotherVideo = collection.get(1);
            System.out.println(anotherVideo);
        }
    }
}
