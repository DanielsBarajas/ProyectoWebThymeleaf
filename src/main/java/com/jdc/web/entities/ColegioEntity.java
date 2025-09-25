package com.jdc.web.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="colegios")

public class ColegioEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcolegio")
    private int idcolegio;

    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    @NotNull
    @Column(name = "descripcion")
    @Size(min = 0, max = 200)
    private String descripcion;

    public int getIdcolegio() {
        return idcolegio;
    }

    public void setIdcolegio(int idcolegio) {
        this.idcolegio = idcolegio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
