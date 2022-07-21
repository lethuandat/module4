package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.SongRepository;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void update(int id, Song song) {
        songRepository.update(id, song);
    }

    @Override
    public void remove(int id) {
        songRepository.remove(id);
    }
}
