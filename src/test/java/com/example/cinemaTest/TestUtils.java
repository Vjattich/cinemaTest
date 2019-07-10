package com.example.cinemaTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import java.io.IOException;
import java.util.StringJoiner;

public class TestUtils {

    public static String toJsonList(String... elements) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");

        for (String element : elements) stringJoiner.add(element);

        return stringJoiner.toString();
    }

    public static String toJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new Hibernate5Module());

        return objectMapper.writeValueAsString(object);
    }

    public static Object fromJson(String object, Class clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new Hibernate5Module());

        return objectMapper.readValue(object, clazz);
    }

}
