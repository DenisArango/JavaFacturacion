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
public class Cliente {
    Connection conn = null;
    PreparedStatement st = null;
    CallableStatement cs = null;
    CreateConection cn = new CreateConection();
    String qry = null;
    ResultSet rs = null;
    int completado = 1;
    
    public int idCliente;
    public String nombre;
    public String apellido;
    public String razonSocial;
    public String nit;
    public String direccion;
    public String telefono;
    public String email;
    public String fechaCreacion;
    public int estado;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public int agregarCliente(String nombre, String apellido, String razonSocial, String nit, String direccion, String telefono, String email, int estado){
        try {
            qry = "CALL AGREGAR_CLIENTE(?,?,?,?,?,?,?,?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setString(1, nombre);
            cs.setString(2, apellido);
            cs.setString(3, razonSocial);
            cs.setString(4, nit);
            cs.setString(5, direccion);
            cs.setString(6, telefono);
            cs.setString(7, email);
            cs.setInt(8, estado);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
    
    public int actualizarCliente(int idCliente, String nombre, String apellido, String razonSocial, String nit, String direccion, String telefono, String email, int estado){
        try {
            qry = "CALL ACTUALIZAR_CLIENTE(?,?,?,?,?,?,?,?,?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, idCliente);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setString(4, razonSocial);
            cs.setString(5, nit);
            cs.setString(6, direccion);
            cs.setString(7, telefono);
            cs.setString(8, email);
            cs.setInt(9, estado);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
    
    public int eliminarCliente(int idCliente){
        try {
            qry = "CALL ELIMINAR_CLIENTE(?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, idCliente);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
}
