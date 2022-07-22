package vn.codegym.validate_song.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.validate_song.model.Song;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
