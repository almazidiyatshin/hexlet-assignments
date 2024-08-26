package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;

@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            var result = mapper.writeValueAsString(this);
            return result;
        } catch (JsonProcessingException e) {
            System.out.println("Error!");
            return null;
        }
    }

    public static Car deserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            var result = mapper.readValue(json, Car.class);
            return result;
        } catch (IOException e) {
            System.out.println("Error!");
            return null;
        }
    }
    // END
}
