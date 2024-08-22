package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> list, int count) {
        return list.stream()
                .sorted(Home::compareTo)
                .limit(count)
                .map(Home::toString)
                .toList();
    }
}
// END
