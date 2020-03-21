import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream(catalog.getPath());
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(catalog);
            objectOut.close();
            System.out.println("Succesfully written");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public static Catalog load(String path)
            throws InvalidCatalogException, FileNotFoundException {
        try {
            FileInputStream inputFile = new FileInputStream(path);
            ObjectInputStream inStream = new ObjectInputStream(inputFile);
            Catalog catalog = (Catalog) inStream.readObject();
            System.out.print("Found");
            inStream.close();
            //System.out.println(catalog.toString());
            return catalog;

        } catch (ClassNotFoundException exception) {
            System.out.print("Class Not found");
            exception.printStackTrace();
            return null;
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static void view(Document doc) {
        try {
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
                if( doc.getLocation().contains("https")){
                    URI outURL = new URI(doc.getLocation());
                    desktop.browse(outURL);
                }else {
                    desktop.open(new File(doc.getLocation()));
                }
            }else{
                throw new RuntimeException("Desktop not supported");
            }

        } catch (IOException | URISyntaxException exception) {
            System.out.println("FUCK");
            exception.printStackTrace();
        }

    }

}


