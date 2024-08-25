package exercise;

// BEGIN
class InputTag implements TagInterface {
    private String type;
    private String value;

    InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String render() {
        return "<input type=\"" + type + "\" value=\"" + value + "\">";
    }
}
// END
