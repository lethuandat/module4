package com.codegym.repository.impl;

import com.codegym.repository.LanguageRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {
    private static final List<String> list;

    static {
        list = new ArrayList<>();
        list.add("English");
        list.add("Vietnamese");
        list.add("Japanese");
        list.add("Chinese");
    }

    @Override
    public List<String> showAll() {
        return list;
    }
}
