package com.jdc.web.Repository;


import com.jdc.web.entities.ColegioEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ColegioRepository extends CrudRepository<ColegioEntity, Long> {
    @Transactional
    @Modifying
    @Query("Update ColegioEntity SET estado = CASE WHEN estado = true THEN FALSE ELSE TRUE END WHERE idcolegio = ?1")
    public void updateEstado(Long idcolegio);

    @Transactional
    @Query("SELECT col FROM ColegioEntity col WHERE col.idcolegio NOT IN"+"(SELECT dir.colegioEntity.idcolegio FROM RectorEntity dir) AND col.estado = true")
    public List<ColegioEntity> findByRector();

    @Transactional
    @Query("SELECT col FROM ColegioEntity col WHERE col.idcolegio NOT IN"+"(SELECT dir.colegioEntity.idcolegio FROM ContactoEntity dir) AND col.estado = true")
    public List<ColegioEntity> findByContacto();

    @Transactional
    @Query("SELECT col FROM ColegioEntity col WHERE col.idcolegio NOT IN"+"(SELECT dir.colegioEntity.idcolegio FROM SedeEntity dir) AND col.estado = true")
    public List<ColegioEntity> findBySede();

}
