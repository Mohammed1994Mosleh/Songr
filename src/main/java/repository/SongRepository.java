package repository;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Integer> {
    List<Song> findAllByAlbum(Album album);
}
