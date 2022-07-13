package com.codegym.service;

import com.codegym.repository.ConvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService{
    @Autowired
    ConvertRepository convertRepository;

    @Override
    public double convert(double rate, double usd) {
        return convertRepository.convert(rate, usd);
    }
}
