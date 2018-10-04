/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conexion;
import DTO.personaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc-Personal
 */
public class personaDAO {

    public void insertar(personaDTO persona) {
        Connection con = null;

        try {
            String sql = "INSERT INTO persona "
                    + "(CEDULA, NOMBRE, TELEFONO, DIRECCION, FECHA_PERSONA) "
                    + "values (?,?,?,?,sysdate)";
            System.out.println("la sentencia :: " + sql);
            conexion cone = new conexion();
            con = cone.getConneccion();
            System.out.println("ya estamos conectados");
            PreparedStatement pstm1 = con.prepareStatement(sql);
            pstm1.setString(1, persona.getCEDULA());
            pstm1.setString(2, persona.getNOMBRE());
            pstm1.setString(3, persona.getTELEFONO());
            pstm1.setString(4, persona.getDIRECCION());
            pstm1.execute();
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public personaDTO consultar(personaDTO persona) {
        try {
            String sql = "select NOMBRE, TELEFONO, DIRECCION, FECHA_PERSONA from persona "
                    + "where CEDULA = ? ";
            System.out.println("la sentencia ::" + sql);
            conexion cone = new conexion();
            Connection con = cone.getConneccion();
            System.out.println("ya estamos conectados");
            PreparedStatement pstm1 = con.prepareCall(sql);
            pstm1.setString(1, persona.getCEDULA());
            ResultSet rset = pstm1.executeQuery();
            if (rset.next()) {
                persona.setNOMBRE(rset.getString("nombre"));
                persona.setTELEFONO(rset.getString("telefono"));
                persona.setDIRECCION(rset.getString("direccion"));
            }

            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persona;
    }

    public void actualiza(personaDTO persona) {
        Connection con = null;
        try {
            String sql = "UPDATE  persona SET"
                    + " NOMBRE = ?, TELEFONO = ?, DIRECCION = ?"
                    + " WHERE CEDULA = ?";
            System.out.println("la sentencia ::" + sql);
            conexion cone = new conexion();
            con = cone.getConneccion();
            System.out.println("ya estamos conectados");
            PreparedStatement pstm2 = con.prepareStatement(sql);
            pstm2.setString(1, persona.getNOMBRE());
            pstm2.setString(2, persona.getTELEFONO());
            pstm2.setString(3, persona.getDIRECCION());
            pstm2.setString(4, persona.getCEDULA());
            pstm2.execute();
            con.commit();

        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void borrar(personaDTO persona) {
        Connection con = null;
        try {
            String sql = "delete persona "
                    + " where CEDULA = ?";
            System.out.println("la sentencia ::" + sql);
            conexion cone = new conexion();
            con = cone.getConneccion();
            System.out.println("ya estamos conectados");
            PreparedStatement pstm1 = con.prepareStatement(sql);
            pstm1.setString(1, persona.getCEDULA());
            pstm1.executeUpdate();
            con.commit();
        } catch (Exception ex) {
            Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(personaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
