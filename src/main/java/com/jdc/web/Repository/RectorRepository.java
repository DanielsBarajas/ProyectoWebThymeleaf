package com.jdc.web.Repository;


import com.jdc.web.entities.RectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RectorRepository extends CrudRepository<RectorEntity, Long> {
}
