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
public class Proveedor {
    Connection conn = null;
    PreparedStatement st = null;
    CallableStatement cs = null;
    CreateConection cn = new CreateConection();
    String qry = null;
    ResultSet rs = null;
    int completado = 1;
    
    public int id_prov;
    public String nombre;
    public String direccion;
    public String telefono;
    public String nit;
    public String fechaCreacion;
    

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fecha_creacion) {
        this.fechaCreacion = fecha_creacion;
    }
    
    public int agregarProveedor(String empresa, String direccion, String ciudad, String pais, String telefono, String nit, String email){
        try {
            qry = "CALL AGREGAR_PROVEEDOR(?,?,?,?,?,?,?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setString(1, empresa);
            cs.setString(2, direccion);
            cs.setString(3, ciudad);
            cs.setString(4, pais);
            cs.setString(5, telefono);
            cs.setString(6, nit);
            cs.setString(7, email);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
    
    public int actualizarProveedor(int idProv, String empresa, String direccion, String ciudad, String pais, String telefono, String nit, String email){
        try {
            qry = "CALL ACTUALIZAR_PROVEEDOR(?,?,?,?,?,?,?,?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, idProv);
            cs.setString(2, empresa);
            cs.setString(3, direccion);
            cs.setString(4, ciudad);
            cs.setString(5, pais);
            cs.setString(6, telefono);
            cs.setString(7, nit);
            cs.setString(8, email);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
    
    public int eliminarProveedor(int idProv){
        try {
            qry = "CALL ELIMINAR_PROVEEDOR(?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, idProv);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
}
