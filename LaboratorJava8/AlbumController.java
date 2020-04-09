public interface AlbumController {
    public Boolean create(String name,Integer artistId,Integer releaseYear);
    public Album findByArtist(Artist artist);
}
