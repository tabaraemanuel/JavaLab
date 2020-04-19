package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ALBUM", schema = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "AlbumEntity.findByArtistId", query = "SELECT album FROM AlbumEntity album WHERE album.id= :artist_id"),
        @NamedQuery(name = "AlbumEntity.findByName", query = "SELECT album FROM AlbumEntity album WHERE album.name LIKE :name")
})
public class AlbumEntity {
    private long id;
    private String name;
    private Long releaseYear;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "RELEASE_YEAR")
    public Long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumEntity that = (AlbumEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(releaseYear, that.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseYear);
    }
}
