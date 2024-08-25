package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> children) {
        super(tagName, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder stringedChildren = new StringBuilder();

        for (var child : children) {
            stringedChildren.append(child.toString());
        }

        return "<" + tagName + ">" + body + stringedChildren + "</" + tagName + ">";
    }
}
// END
