package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class SandwichSpiceServiceImpl implements SandwichSpiceService {

    @Override
    public String save(String[] condiment) {
        StringBuilder spice = new StringBuilder();

        for (String s : condiment) {
            spice.append(s).append(" ");
        }

        return spice.toString();
    }
}
