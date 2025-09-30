package com.jdc.web.Repository;


import com.jdc.web.entities.ColegioEntity;
import com.jdc.web.entities.RectorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RectorRepository extends CrudRepository<RectorEntity, Long> {


    @Transactional
    @Query("SELECT rect FROM RectorEntity rect WHERE rect.numdocumento = 1")
    public List<RectorEntity> findByRector();


}
