package com.codegym.repository.impl;

import com.codegym.model.Email;
import com.codegym.repository.EmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepositoryImpl implements EmailRepository {
    private static final List<Email> emailList;

    static {
        emailList = new ArrayList<>();
        emailList.add(new Email(1, "English", 5, true, "Le Nam"));
        emailList.add(new Email(2, "Chinese", 100, false, "Le Hung"));
        emailList.add(new Email(3, "Japanese", 25, false, "Le Long"));
        emailList.add(new Email(4, "Vietnamese", 15, true, "Le Quy"));
    }

    private static final List<String> languageList;

    static {
        languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }

    private static final List<Integer> pageSizeList;

    static {
        pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

    @Override
    public List<Integer> showPageSize() {
        return pageSizeList;
    }

    @Override
    public List<String> showLanguage() {
        return languageList;
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public Email findOne(Integer id) {
        Email email = null;
        for (Email item : emailList) {
            if (item.getId().equals(id)) {
                email = new Email(item.getId(), item.getLanguage(), item.getPageSize(), item.isSpamFilter(), item.getSignature());
            }
        }
        return email;
    }

    @Override
    public void save(Integer id, Email email) {
        for (Email value : emailList) {
            if (id.equals(value.getId())) {
                value.setLanguage(email.getLanguage());
                value.setPageSize(email.getPageSize());
                value.setSpamFilter(email.isSpamFilter());
                value.setSignature(email.getSignature());
            }
        }
    }
}
