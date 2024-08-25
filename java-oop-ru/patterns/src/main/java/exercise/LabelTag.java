package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private String label;
    private TagInterface tag;

    LabelTag(String label, TagInterface tag) {
        this.label = label;
        this.tag = tag;
    }

    public String render() {
        return "<label>" + label + tag.render() + "</label>";
    }
}
// END
