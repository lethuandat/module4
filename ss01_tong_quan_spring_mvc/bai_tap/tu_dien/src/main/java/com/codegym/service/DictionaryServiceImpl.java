package com.codegym.service;

import com.codegym.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public String translate(String txtSearch) {
        return dictionaryRepository.translate(txtSearch);
    }
}
