package com.jdc.web.Repository;


import com.jdc.web.entities.ContactoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends CrudRepository<ContactoEntity,Long> {
}
