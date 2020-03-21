import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {

    private String name;
    private String location;
    private String ID;
    private Map<String, Object> tags = new HashMap<>();

    public Document(String name, String ID, String location) {
        this.name = name;
        this.location = location;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getID() {
        return ID;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", ID='" + ID + '\'' +
                ", tags=" + tags +
                '}';
    }
}




