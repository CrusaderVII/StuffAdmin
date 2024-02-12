package com.egor.stuff_admin.stuff_service.controller.converter;

import com.egor.stuff_admin.stuff_service.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEmployeeConverter implements Converter<String, Employee> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public Employee convert(String source) {
        return objectMapper.readValue(source, Employee.class);
    }
}
