package com.jdc.web.Services;

import com.jdc.web.entities.ColegioEntity;

import java.util.List;

public interface ColegioService {

    public List<ColegioEntity> findAll();

    public ColegioEntity findById(Long id);

    public void save(ColegioEntity colegioEntity);

    public void deleteById(Long id);

    public void updateEstado(Long id);

    public List<ColegioEntity> findByRector();

    public List<ColegioEntity> findByContacto();

    public List<ColegioEntity> findBySede();

    public List<ColegioEntity> findByLetra();

}
