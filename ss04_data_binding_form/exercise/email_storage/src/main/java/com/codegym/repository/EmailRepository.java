package com.codegym.repository;

import com.codegym.model.Email;

import java.util.List;

public interface EmailRepository {
    List<Email> findAll();

    Email findOne(Integer id);

    void save(Integer id, Email email);

    List<String> showLanguage();

    List<Integer> showPageSize();
}
