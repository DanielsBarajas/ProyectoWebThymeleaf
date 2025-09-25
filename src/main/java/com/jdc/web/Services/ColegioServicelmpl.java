package com.jdc.web.Services;

import com.jdc.web.Repository.ColegioRepository;
import com.jdc.web.entities.ColegioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ColegioServicelmpl implements ColegioService {

    @Autowired
    private ColegioRepository colegioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ColegioEntity> findAll() {
        return (List<ColegioEntity>) colegioRepository.findAll();


    }

    @Override
    @Transactional(readOnly = true)
    public ColegioEntity findById(Long id) {
        return  colegioRepository.findById(id).orElse(null);


    }

    @Override
    @Transactional
    public void save(ColegioEntity colegioEntity) {
        colegioRepository.save(colegioEntity);


    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        colegioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateEstado(Long id){
        colegioRepository.updateEstado(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ColegioEntity> findByRector(){
        return colegioRepository.findByRector();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ColegioEntity> findByContacto(){
        return colegioRepository.findByContacto();
    }
    @Override
    @Transactional(readOnly = true)
    public List<ColegioEntity> findBySede(){
        return colegioRepository.findBySede();
    }

}
