package com.pedro.tarefas.exception;

public class RecordNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id) {
        super("Record not found with ID: " + id);
    }

    public RecordNotFoundException(Long id, Throwable cause) {
        super("Record not found with ID: " + id, cause);
    }

}
