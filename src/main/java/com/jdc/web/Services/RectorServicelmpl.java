package com.jdc.web.Services;


import com.jdc.web.DTO.RectorDTO;
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
    public List<RectorDTO> findAll() {

        List<RectorEntity> lista = (List<RectorEntity>) rectorRepository.findAll();


        return lista.stream().map(rector -> new RectorDTO(rector.getIdrector(),rector.getNombre(),rector.getPrimerapellido(),rector.getSegundoapellido(),rector.getNumdocumento(),rector.getFechanacimiento(),rector.getTipodocumento(),rector.getColegio())).toList();


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

    @Override
    @Transactional(readOnly = true)
    public List<RectorDTO> findByRector() {
        List<RectorEntity> lista = (List<RectorEntity>) rectorRepository.findByRector();


        return lista.stream().map(rector -> new RectorDTO(rector.getIdrector(),rector.getNombre(),rector.getPrimerapellido(),rector.getSegundoapellido(),rector.getNumdocumento(),rector.getFechanacimiento(),rector.getTipodocumento(),rector.getColegio())).toList();
    }


}
