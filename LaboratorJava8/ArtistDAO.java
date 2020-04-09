import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.Statement;

public class ArtistDAO implements ArtistController {

    @Override
    public boolean create(String name, String country) {
        Statement statement = Database.getInstance().getStatement() ;
        Artist artist = new Artist(name,country);
        try{
            String query = "INSERT INTO artists " + "VALUES (43," +"'"+ artist.getName() + "'"+ " ," +"'"+ artist.getCountry() +"'" +" )";

            System.out.println(query);
            statement.executeUpdate(query);
        }catch(Exception e ){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Artist findByName(String name) {
        Statement statement = Database.getInstance().getStatement();
        try{
            String query = "SELECT * FROM ARTISTS WHERE NAME="+"'"+name+"'";
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);
            System.out.println(rs.toString());
            String countryResult= " failed";
            String nameResult = " failed";
            while(rs.next()) {

                 nameResult = rs.getString(2);
                 countryResult = rs.getString(3);
            }
            Artist resultArtist = new Artist(nameResult,countryResult);
            return resultArtist;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
