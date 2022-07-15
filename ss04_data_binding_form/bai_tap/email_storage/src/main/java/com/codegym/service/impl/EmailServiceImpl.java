package com.codegym.service.impl;

import com.codegym.model.Email;
import com.codegym.repository.EmailRepository;
import com.codegym.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    EmailRepository emailRepository;

    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public Email findOne(Integer id) {
        return emailRepository.findOne(id);
    }

    @Override
    public void save(Integer id, Email email) {
        emailRepository.save(id, email);
    }

    @Override
    public List<String> showLanguage() {
        return emailRepository.showLanguage();
    }

    @Override
    public List<Integer> showPageSize() {
        return emailRepository.showPageSize();
    }
}
