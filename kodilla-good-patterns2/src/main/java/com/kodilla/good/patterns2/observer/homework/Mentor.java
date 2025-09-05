package com.kodilla.good.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;

    public Mentor(String name) {
        this.mentorName = name;
    }

    @Override
    public void update(Student student, String task) {
        System.out.println(mentorName + ": New task from: " + student.getName() + "\n" +
                "New task: \"" + task + "\"\n" +
                " (total number of tasks to check: " + student.getNumberOfTasks() + ")");
    }

    @Override
    public void removeFirstTask(Student student) {
        if (!student.getTasks().isEmpty()) {
            student.getTasks().removeFirst();
        }
    }

    public String getName() {
        return mentorName;
    }
}
