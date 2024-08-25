package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {
    SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    public String toString() {
        StringBuilder attrs = new StringBuilder();

        for (var entry : this.attributes.entrySet()) {
            attrs.append(entry.getKey())
                    .append("=\"")
                    .append(entry.getValue())
                    .append("\" ");
        }

        String trimmedAttrs = attrs.toString().trim();

        eturn "<" + tagName + (trimmedAttrs.isEmpty() ? "" : " " + trimmedAttrs) + ">";
    }
}
// END
