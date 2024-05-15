package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String serializeHouse(House house) throws JsonProcessingException {
        return objectMapper.writeValueAsString(house);
    }

    public static House deserializeHouse(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, House.class);
    }
}
