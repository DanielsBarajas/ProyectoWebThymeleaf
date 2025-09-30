package com.jdc.web.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Rectores")

public class RectorEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrector")
    private int idrector;

    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "primer_apellido")
    private String primerapellido;

    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "segundo_apellido")
    private String segundoapellido;

    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column (name = "num_documento")
    private int numdocumento;

    @NotNull
    @Column(name = "tipo_documento")
    private int tipodocumento;

    @NotNull
    @Column (name = "fecha_nacimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;


    @NotNull
    @OneToOne
    @JoinColumn(name = "idcolegio", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ColegioEntity colegioEntity;

    public ColegioEntity getColegio() {
        return colegioEntity;
    }

    public void setColegio(ColegioEntity colegioEntity) {
        this.colegioEntity = colegioEntity;
    }

    public int getIdrector() {
        return idrector;
    }

    public void setIdrector(int idrector) {
        this.idrector = idrector;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primer_apellido) {
        this.primerapellido = primer_apellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoApellido) {
        this.segundoapellido = segundoApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(int num_documento) {
        this.numdocumento = num_documento;
    }

    public int getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(int tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fecha_nacimiento) {
        this.fechanacimiento = fecha_nacimiento;
    }
}
