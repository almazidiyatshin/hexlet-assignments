package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var copy = new Map<String, String>(storage.toMap());
        var entries = copy.toMap().entrySet();

        for (var entry : entries) {
            var key = entry.getKey();
            var value = entry.getValue();

            storage.set(value, key);
            storage.unset(key);
        }
    }
}
// END
