package com.jdc.web.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table (name = "Sedes")


public class SedeEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSedes")
    private int idsede;

    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Size(min = 0, max = 150)
    @Column(name = "direccion")
    private String direccion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "idcolegio",referencedColumnName = "idcolegio" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ColegioEntity colegioEntity;

    public ColegioEntity getColegio() {
        return colegioEntity;
    }

    public void setColegio(ColegioEntity colegioEntity) {
        this.colegioEntity = colegioEntity;
    }

    public int getIdsede() {
        return idsede;
    }

    public void setIdsede(int idSedes) {
        this.idsede = idSedes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
