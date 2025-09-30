package com.jdc.web.Repository;


import com.jdc.web.entities.ContactoEntity;
import com.jdc.web.entities.RectorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContactoRepository extends CrudRepository<ContactoEntity,Long> {

    @Transactional
    @Query(value = "SELECT * FROM contactos LIMIT 8", nativeQuery = true)
    public List<ContactoEntity> findFirstContactos();
}
