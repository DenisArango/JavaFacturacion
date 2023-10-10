/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.CreateConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlUsuarios extends Conexion.CreateConection {
    
    Connection conn = null;
    PreparedStatement st = null;
    CreateConection cn = new CreateConection();
    String qry = null;
    ResultSet rs = null;
    
    public int validarUsuario(String usuario, String contraseña){
        int validate = 0;
        try {
            conn = cn.getConection();
            qry = "SELECT VALIDATE_USER(?,?)";
            st = conn.prepareStatement(qry);
            st.setString(1, usuario);
            st.setString(2, contraseña);
            rs = st.executeQuery();
            if(rs.next()){
                System.out.println(rs.getInt("VALIDATE_USER"));
                validate = rs.getInt("VALIDATE_USER");
            }
            st.close();
            conn.close();
            return validate;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return validate;
        }
    }
    
    public boolean Login (String usuario, String contraseña){
        Usuario usr = new Usuario();
        
        if(validarUsuario(usuario, contraseña) == 1){
            try {
                conn = cn.getConection();
                qry = "SELECT U.ID_USUARIO, U.USUARIO, U.CONTRASEÑA, R.ID_ROL FROM USUARIO U INNER JOIN ROL R ON U.ID_ROL = R.ID_ROL WHERE U.USUARIO = ? AND U.CONTRASEÑA = ?;";
                st = conn.prepareStatement(qry);
                st.setString(1, usuario);
                st.setString(2, contraseña);
                rs = st.executeQuery();

                if(rs.next()){
                    usr.setIdUsuario(rs.getInt("ID_USUARIO"));
                    usr.setUsuario(rs.getString("USUARIO"));
                    usr.setContraseña(rs.getString("CONTRASEÑA"));
                    usr.setIdRol(rs.getInt("ID_ROL"));
                    return true;
                }else{
                    return false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);     
                return false;
            }
        }else{
            return false;
        }
        
    }
}
