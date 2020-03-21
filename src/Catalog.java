import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private String name;
    private String path;
    private List<Document> document = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void add(Document doc) {
        document.add(doc);
    }
    public Document findById(String id) {
        int indexLoc = 0;
        for(int j = 0; j < this.document.size();j++ )
            if(document.get(j).getID().equals(id)){
                indexLoc = j;
                break;
            }
         return document.get(indexLoc);
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
                ", document=" + document.toString() +
                '}';
    }
}
