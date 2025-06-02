package com.pedro.tarefas.enums;

public enum Status {

    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    private String value;

    private Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
