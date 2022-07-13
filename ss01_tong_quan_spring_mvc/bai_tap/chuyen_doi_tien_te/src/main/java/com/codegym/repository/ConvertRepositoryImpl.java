package com.codegym.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ConvertRepositoryImpl implements ConvertRepository{
    @Override
    public double convert(double rate, double usd) {
        return  rate * usd;
    }
}
