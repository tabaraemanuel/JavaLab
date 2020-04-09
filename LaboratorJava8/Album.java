public class Album {
    private String name;
    private Integer artistId;
    private Integer releaseYear;

    public Album(String name, Integer artistId, Integer releaseYear) {
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }
}
