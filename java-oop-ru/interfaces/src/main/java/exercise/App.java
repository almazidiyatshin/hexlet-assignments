package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> list, int count) {
        return list.stream()
                .sorted((a, b) -> a.compareTo(b))
                .limit(count)
                .map(a -> a.toString())
                .toList();
    }
}
// END
