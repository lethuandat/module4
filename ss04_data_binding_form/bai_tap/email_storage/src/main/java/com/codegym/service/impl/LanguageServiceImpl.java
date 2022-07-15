package com.codegym.service.impl;

import com.codegym.repository.LanguageRepository;
import com.codegym.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<String> showAll() {
        return languageRepository.showAll();
    }
}
