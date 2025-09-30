package com.jdc.web.Services;

import com.jdc.web.Repository.SedeRepository;
import com.jdc.web.entities.SedeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SedeServicelmpl implements  SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SedeEntity> findAll() {
        return (List<SedeEntity>) sedeRepository.findAll();


    }

    @Override
    @Transactional(readOnly = true)
    public SedeEntity findById(Long id) {
        return sedeRepository.findById(id).orElse(null);


    }

    @Override
    @Transactional
    public void save(SedeEntity sedeEntity) {
        sedeRepository.save(sedeEntity);


    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        sedeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<SedeEntity> findSedeMayorIgualAseis() {
        return sedeRepository.findSedeMayorIgualAseis();
    }
}
