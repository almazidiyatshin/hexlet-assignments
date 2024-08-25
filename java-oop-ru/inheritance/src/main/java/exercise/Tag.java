package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
abstract class Tag {
    private String tagName;
    private Map<String, String> attributes;

    Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    abstract String toString();
}
// END
