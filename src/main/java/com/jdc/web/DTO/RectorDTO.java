package com.jdc.web.DTO;

import com.jdc.web.entities.ColegioEntity;

import java.util.Date;

public class RectorDTO {
    private int idrector;
    private String nombre;
    private String primerapellido;
    private String segundoapellido;
    private int numdocumento;

    private Date fechanacimiento;
    private int tipodocumento;
    private String tipoDocumentoTexto;
    private ColegioEntity colegioEntity;



//    public RectorDTO(int id, String nombre, Integer tipoDocumento) {
//        this.id = id;
//        this.nombre = nombre;
//        this.tipoDocumento = tipoDocumento;
//        this.tipoDocumentoTexto = mapearTipoDocumento(tipoDocumento);
//    }


    public RectorDTO(int id, String nombre, String primerapellido, String segundoapellido, int numdocumento, Date fechanacimiento, int tipodocumento ,ColegioEntity colegioEntity) {
        this.idrector = id;
        this.nombre = nombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.numdocumento = numdocumento;
        this.fechanacimiento = fechanacimiento;
        this.tipodocumento = tipodocumento;
        this.tipoDocumentoTexto = mapearTipoDocumento(tipodocumento);
        this.colegioEntity = colegioEntity;
    }

    private String mapearTipoDocumento(int  tipo) {
        return switch (tipo) {
            case 1 -> "CC";
            case 2 -> "TI";
            case 3 -> "CE";
            default -> "Desconocido";
        };
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public int getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(int numdocumento) {
        this.numdocumento = numdocumento;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public ColegioEntity getColegioEntity() {
        return colegioEntity;
    }

    public void setColegioEntity(ColegioEntity colegioEntity) {
        this.colegioEntity = colegioEntity;
    }


    public int getIdrector() {
        return idrector;
    }

    public void setIdrector(int idrector) {
        this.idrector = idrector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(int tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getTipoDocumentoTexto() {
        return tipoDocumentoTexto;
    }

    public void setTipoDocumentoTexto(String tipoDocumentoTexto) {
        this.tipoDocumentoTexto = tipoDocumentoTexto;
    }
}
