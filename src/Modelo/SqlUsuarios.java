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
            qry = "SELECT ESTADO FROM USUARIO WHERE USUARIO = ? AND CONTRASEÑA = ?";
            st = conn.prepareStatement(qry);
            st.setString(1, usuario);
            st.setString(2, contraseña);
            rs = st.executeQuery();
            if(rs.next()){
                if(rs.getInt("ESTADO") == 1){
                    validate++;
                }else{
                    validate--;
                }
            }
            st.close();
            conn.close();
            return validate;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return validate;
        }
    }
    
    public int Login (Usuario usr){
        String usuario = usr.getUsuario();
        String contraseña = usr.getContraseña();
        int validate = validarUsuario(usuario, contraseña);
        if (validate == 1){
            try {
                conn = cn.getConection();
                qry = "SELECT U.ID_USUARIO, U.USUARIO, U.CONTRASEÑA, R.ID_ROL FROM USUARIO U INNER JOIN ROL R ON U.ID_ROL = R.ID_ROL WHERE U.USUARIO = ? AND U.CONTRASEÑA = ?;";
                st = conn.prepareStatement(qry);
                st.setString(1, usuario);
                st.setString(2, contraseña);
                rs = st.executeQuery();

                if(rs.next()){
                    usr.setIdUsuario(rs.getInt("ID_USUARIO"));
                    usr.setIdRol(rs.getInt("ID_ROL"));                        
                }

            } catch (SQLException ex) {     
                Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }
        return validate;
    }
}
