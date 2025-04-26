package com.kodilla.stream.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringOperationsTestSuite {
    @Test
    void mirrorTest() {
        //Given
//        String[] examples = {"Adam", "Ewa", "Kajak"};
        // alternative approach
        List<String> examples = new ArrayList<>(Arrays.asList("Adam", "Ewa", "Kajak"));

        //When
        List<String> afterMirror = new ArrayList<>();

        for (String example : examples) {
            afterMirror.add(StringOperations.mirror(example));
        }

        //Then
        assertEquals("madA", afterMirror.get(0));
        assertEquals("awE", afterMirror.get(1));
        assertEquals("kajaK", afterMirror.get(2));
    }
}
