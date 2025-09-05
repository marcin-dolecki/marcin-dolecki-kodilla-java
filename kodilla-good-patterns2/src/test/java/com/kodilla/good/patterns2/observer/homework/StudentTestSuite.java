package com.kodilla.good.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTestSuite {

    @Test
    void testUpdate() {
        Student studentBartek = new BartekStudent();
        Student studentKamil = new KamilStudent();
        Student studentMarek = new MarekStudent();
        Mentor mentorAdam = new Mentor("Adam Nowak");
        Mentor mentorJan = new Mentor("Jane Kowalski");
        studentBartek.registerObserver(mentorAdam);
        studentKamil.registerObserver(mentorJan);
        studentMarek.registerObserver(mentorJan);

        studentBartek.addTask("Java basics");
        studentBartek.addTask("Java medium");
        studentBartek.addTask("Java advanced");
        mentorAdam.removeFirstTask(studentBartek);
        studentBartek.addTask("Java extra tasks");
        studentKamil.addTask("Java basics");
        studentMarek.addTask("Java medium");
        studentKamil.addTask("Java medium");
        studentMarek.addTask("Java basics");
        studentMarek.addTask("Java advanced");

        assertEquals(3, studentBartek.getNumberOfTasks());
        assertEquals(2, studentKamil.getNumberOfTasks());
        assertEquals(3, studentMarek.getNumberOfTasks());
    }
}
