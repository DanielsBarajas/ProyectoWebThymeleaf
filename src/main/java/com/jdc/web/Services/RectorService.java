package com.jdc.web.Services;


import com.jdc.web.DTO.RectorDTO;
import com.jdc.web.entities.RectorEntity;

import java.util.List;

public interface RectorService {


    public List<RectorDTO> findAll();

    public RectorEntity findById(Long id);

    public void save(RectorEntity rectorEntity);

    public void deleteById(Long id);

    public List<RectorDTO> findByRector();

}

