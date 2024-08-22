package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    private Map<String, String> map;
    public InMemoryKV(Map<String, String> map) {
        this.map = map;
    }

    public set(String key, String value) {
        this.map.put(key, value);
    }

    public unset(String key) {
        this.map.remove(key);
    }

    public String get(String key) {
        return this.map.get(key);
    }

    public Map<String, String> toMap() {
        return this.map;
    }
}
// END
