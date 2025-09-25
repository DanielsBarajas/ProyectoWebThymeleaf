package com.jdc.web.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table (name = "Contactos")

public class ContactoEntity implements Serializable {



    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idContacto")
    private int idcontacto;

    @NotNull
    @Column (name = "tipo_contacto")
    private int tipocontacto;

    @NotNull
    @Size(min = 0, max = 50)
    @Column (name = "numero")
    private String numero;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcolegio", referencedColumnName = "idcolegio", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ColegioEntity colegioEntity;

    public ColegioEntity getColegio() {
        return colegioEntity;
    }

    public void setColegio(ColegioEntity colegioEntity) {
        this.colegioEntity = colegioEntity;
    }

    public int getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(int idContacto) {
        this.idcontacto = idContacto;
    }

    public int getTipocontacto() {
        return tipocontacto;
    }

    public void setTipocontacto(int tipoContacto) {
        this.tipocontacto = tipoContacto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
