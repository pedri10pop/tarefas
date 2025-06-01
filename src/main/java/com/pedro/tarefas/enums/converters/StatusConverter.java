package com.pedro.tarefas.enums.converters;

import java.util.stream.Stream;

import com.pedro.tarefas.enums.Status;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.toString();
    }

    @Override
    public Status convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(Status.values())
                .filter(s -> s.toString().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown status: " + dbData));
    }

}
