package com.codegym.repository.impl;

import com.codegym.repository.PageSizeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PageSizeRepositoryImpl implements PageSizeRepository {
    private static final List<Integer> list;

    static {
        list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(25);
        list.add(50);
        list.add(100);
    }

    @Override
    public List<Integer> showAll() {
        return list;
    }
}
