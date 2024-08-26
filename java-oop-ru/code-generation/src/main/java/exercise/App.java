package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
import java.io.IOException;

class App {
    public static void save(Path path, Car car) {
        var string = car.serialize();

        try {
            Files.writeString(path, string);
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    public static Car extract(Path path) {
        try {
            var string = Files.readString(path);
            return Car.deserialize(string);
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }
}
// END
