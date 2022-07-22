package vn.codegym.validate_song.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.validate_song.model.Song;
import vn.codegym.validate_song.repository.ISongRepository;
import vn.codegym.validate_song.service.ISongService;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Optional<Song> findById(int id) {
        return iSongRepository.findById(id);
    }
}
