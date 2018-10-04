/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Pc-Personal
 */
public class personaDTO {

    private String CEDULA;
    private String NOMBRE;
    private String TELEFONO;
    private String DIRECCION;
    private Date FECHA_PERSONA;

    public String toString() {
        return "Persona [ "
                + " CEDULA=" + CEDULA
                + " NOMBRE=" + NOMBRE
                + " TELEFONO=" + TELEFONO
                + " DIRECCION=" + DIRECCION
                + " ]";
    }

    public String getCEDULA() {
        return CEDULA;
    }

    public void setCEDULA(String CEDULA) {
        this.CEDULA = CEDULA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public Date getFECHA_PERSONA() {
        return FECHA_PERSONA;
    }

    public void setFECHA_PERSONA(Date FECHA_PERSONA) {
        this.FECHA_PERSONA = FECHA_PERSONA;
    }

}
