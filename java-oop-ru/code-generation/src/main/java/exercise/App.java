package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
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
            return car.deserialize(string);
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }
}
// END
