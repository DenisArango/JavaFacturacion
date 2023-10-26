/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.CreateConection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denis Arango
 */
public class Usuario {
    
    Connection conn = null;
    PreparedStatement st = null;
    CallableStatement cs = null;
    CreateConection cn = new CreateConection();
    String qry = null;
    ResultSet rs = null;
    int completado = 1;
    
    public int idUsuario;
    public String usuario;
    public String contraseña;
    public String ultimoInicio;
    public String estado;
    public int idEmpleado;
    public int idRol;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUltimoInicio() {
        return ultimoInicio;
    }

    public void setUltimoInicio(String ultimoInicio) {
        this.ultimoInicio = ultimoInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    public int getIdEmpleadoPorUsuario(String Nombre){
        int id = 0;
        try {
            qry = "SELECT DISTINCT(ID_EMPLEADO) AS ID FROM GET_EMPLEADOS() WHERE NOMBRE = ?";
            conn = cn.getConection();
            st = conn.prepareStatement(qry);
            st.setString(1, Nombre);
            rs = st.executeQuery();
            
            while(rs.next()){
                id = rs.getInt("ID");
            }
            
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return id;
        }
    }
    
    public int getIdRolPorUsuario(String descripcion){
        int id = 0;
        try {
            qry = "SELECT DISTINCT(ID_ROl) AS ID FROM GET_ROLES() WHERE DESCRIPCION = ?";
            conn = cn.getConection();
            st = conn.prepareStatement(qry);
            st.setString(1, descripcion);
            rs = st.executeQuery();
            
            while(rs.next()){
                id = rs.getInt("ID");
            }
            
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return id;
        }
    }
    
    public int agregarUsuario(String Usuario, String Contraseña, int Estado, int IdEmpleado, int IdRol){
        try {
            qry = "CALL AGREGAR_USUARIO(?,?,?,?,?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setString(1, Usuario);
            cs.setString(2, Contraseña);
            cs.setInt(3, Estado);
            cs.setInt(4, IdEmpleado);
            cs.setInt(5, IdRol);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
        public int actualizarUsuario(int idUsuario,String Usuario, String Contraseña, int Estado, int IdEmpleado, int IdRol ){
        try {
            qry = "CALL ACTUALIZAR_USUARIO(?,?,?,?,?,?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, idUsuario);
            cs.setString(2, Usuario);
            cs.setString(3, Contraseña);
            cs.setInt(4, Estado);
            cs.setInt(5, IdEmpleado);
            cs.setInt(6, IdRol);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
         public int eliminarUsuario(int idUsuario){
        try {
            qry = "CALL ELIMINAR_USUARIO(?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, idUsuario);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
}
