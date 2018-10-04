/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc-Personal
 */
public class conexion {
    public  Connection getConneccion() throws Exception {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  //DRIVER DE SQL DEVELOPER
            String myDB = "jdbc:oracle:thin:@flexiwebltda:1521:orcl";//URL DE SQL DEVELOPER
            String usuario = "WILMARPRUEBAZK";
            String password = "sistemas";
            Connection cnx = DriverManager.getConnection(myDB, usuario, password);
            System.out.println("Paso");
            return cnx;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "fallo");
            throw new Exception ("nos jodimos ... ");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
