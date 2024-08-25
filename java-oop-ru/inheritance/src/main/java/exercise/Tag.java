package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
abstract class Tag {
    protected String tagName;
    protected Map<String, String> attributes;

    Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String attrsToString() {
        StringBuilder attrs = new StringBuilder();

        for (var entry : attributes.entrySet()) {
            attrs.append(entry.getKey())
                    .append("=\"")
                    .append(entry.getValue())
                    .append("\" ");
        }

        String trimmedAttrs = attrs.toString().trim();

        return trimmedAttrs.isEmpty() ? "" : " " + trimmedAttrs;
    }

    @Override
    public String toString() {
        String attrs = attrsToString();
        return "<" + tagName + attrs + ">";
    };
}
// END
