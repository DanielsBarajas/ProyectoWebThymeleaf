package com.jdc.web.Services;


import com.jdc.web.Repository.RectorRepository;
import com.jdc.web.entities.RectorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RectorServicelmpl implements RectorService{

    @Autowired
    private RectorRepository rectorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<RectorEntity> findAll() {
        return (List<RectorEntity>) rectorRepository.findAll();


    }

    @Override
    @Transactional(readOnly = true)
    public RectorEntity findById(Long id) {
        return rectorRepository.findById(id).orElse(null);


    }

    @Override
    @Transactional
    public void save(RectorEntity rectorEntity) {
        rectorRepository.save(rectorEntity);


    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        rectorRepository.deleteById(id);
    }
}
