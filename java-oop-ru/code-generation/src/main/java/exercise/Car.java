package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
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
            var result = ObjectMapper.writeValueAsString(this);
            return result;
        } catch (JsonProcessingException e) {
            System.out.println("Error!");
        }
    }

    public static Car deserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            var result = ObjectMapper.readValue(json, Car);
            return result;
        } catch (IOException | JsonParseException | JsonMappingException e) {
            System.out.println("Error!");
        }
    }
    // END
}
