package com.jdc.web.Repository;


import com.jdc.web.entities.SedeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SedeRepository extends CrudRepository<SedeEntity,Long> {
}
