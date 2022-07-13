package com.codegym.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository{
    private static final Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
    }

    @Override
    public String translate(String txtSearch) {
        if (dictionary.get(txtSearch) != null) {
            return dictionary.get(txtSearch);
        } else {
            return "Not found!";
        }
    }
}
