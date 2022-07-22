package vn.codegym.validate_song.service;

import vn.codegym.validate_song.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Optional<Song> findById(int id);
}
