import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void add(Document doc) {
        documents.add(doc);
    }
    public Document findById(String id) {

        for (Document document : this.documents)
            if (document.getID().equals(id)) {
                return document;
            }
        return documents.get(0);
    }

    public String getName() {

        return name;
    }

    public String getPath() {

        return path;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", document=" + documents.toString() +
                '}';
    }
}
