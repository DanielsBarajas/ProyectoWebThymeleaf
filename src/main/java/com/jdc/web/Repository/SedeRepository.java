package com.jdc.web.Repository;


import com.jdc.web.entities.RectorEntity;
import com.jdc.web.entities.SedeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface SedeRepository extends CrudRepository<SedeEntity,Long> {

    @Transactional
    @Query("SELECT sede FROM SedeEntity sede WHERE sede.idsede >= 6")
    public List<SedeEntity> findSedeMayorIgualAseis();



}
