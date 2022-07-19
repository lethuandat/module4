package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ConnectionUtil;
import com.codegym.repository.SongRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SongRepositoryImpl implements SongRepository {
    Session session = null;
    List<Song> songList;

    @Override
    public List<Song> findAll() {
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            songList = session.createQuery("from Song").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return songList;
    }

    @Override
    public void save(Song song) {
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(song);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Song findById(int id) {
        Song song = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();

            song = session.get(Song.class, id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return song;
    }

    @Override
    public void update(int id, Song song) {
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            songList = session.createQuery("from Song").getResultList();
            transaction = session.beginTransaction();

            for (Song item : songList) {
                if (item.getId().equals(id)) {
                    item.setName(song.getName());
                    item.setSinger(song.getSinger());
                    item.setType(song.getType());
                    item.setLinkUrl(song.getLinkUrl());
                }
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            songList = session.createQuery("from Song").getResultList();
            transaction = session.beginTransaction();

            for (Song item : songList) {
                if (item.getId().equals(id)) {
                    session.remove(item);
                }
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
