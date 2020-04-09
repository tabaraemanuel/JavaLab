public class Main {

    public static void main(String[] args) {
        Database database = Database.getInstance();
        database.connect();
        ArtistDAO artistTest = new ArtistDAO();
        AlbumDOA albumTest = new AlbumDOA();
        artistTest.create("Euel","Romania");

        Artist artistResult = artistTest.findByName("Emannuel");
        //albumTest.create("Lithium",2,1988);
        Album resultAlbum = albumTest.findByArtist(artistResult);
        System.out.println(artistResult.getName());
        System.out.println(resultAlbum.getArtistId());
    }
}
