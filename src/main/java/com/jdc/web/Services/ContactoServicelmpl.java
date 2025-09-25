package com.jdc.web.Services;


import com.jdc.web.Repository.ContactoRepository;
import com.jdc.web.entities.ContactoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactoServicelmpl implements ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ContactoEntity> findAll() {
        return (List<ContactoEntity>) contactoRepository.findAll();


    }

    @Override
    @Transactional(readOnly = true)
    public ContactoEntity findById(Long id) {
        return  contactoRepository.findById(id).orElse(null);


    }

    @Override
    @Transactional
    public void save(ContactoEntity contactoEntity) {
        contactoRepository.save(contactoEntity);


    }


    @Override
    @Transactional
    public void deleteById(Long id) {contactoRepository.deleteById(id);
    }
}
