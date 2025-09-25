package com.jdc.web.Services;

import com.jdc.web.entities.SedeEntity;

import java.util.List;

public interface SedeService {


    public List<SedeEntity> findAll();

    public SedeEntity findById(Long id);

    public void save(SedeEntity sedeEntity);

    public void deleteById(Long id);
}

