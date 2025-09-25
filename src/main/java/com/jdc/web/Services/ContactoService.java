package com.jdc.web.Services;

import com.jdc.web.entities.ContactoEntity;

import java.util.List;

public interface ContactoService {


    public List<ContactoEntity> findAll();

    public ContactoEntity findById(Long id);

    public void save(ContactoEntity contactoEntity);

    public void deleteById(Long id);
}

