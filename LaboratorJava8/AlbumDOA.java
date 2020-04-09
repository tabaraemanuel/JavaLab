import java.sql.ResultSet;
import java.sql.Statement;

public class AlbumDOA implements AlbumController {
    @Override
    public Boolean create(String name, Integer artistId, Integer releaseYear) {
        Statement statement = Database.getInstance().getStatement() ;

        try{
            String query = "INSERT INTO album " + "VALUES (8," +"'"+ name + "'"+ " ," +"'"+ artistId +"'"+ " ," + "'"+releaseYear +"'" + " )";
            System.out.println(query);
            statement.executeUpdate(query);
        }catch(Exception e ){
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public Album findByArtist(Artist artist) {
        Statement statement = Database.getInstance().getStatement();
        try{
            String query = "SELECT * FROM album WHERE Artist_id="+"'"+2+"'";

            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);
            System.out.println(rs.toString());
            String nameResult= " failed";
            int artist_id = 0;
            int releaseYear = 0;
            while(rs.next()) {

                nameResult = rs.getString(2);
                artist_id = Integer.parseInt( rs.getString(3));
                releaseYear = Integer.parseInt(rs.getString(4));
            }
            return new Album(nameResult,artist_id,releaseYear);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
