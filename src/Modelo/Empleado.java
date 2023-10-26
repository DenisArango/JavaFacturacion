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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;

/**
 *
 * @author Denis Arango
 */
public class Empleado {
    Connection conn = null;
    PreparedStatement st = null;
    CallableStatement cs = null;
    CreateConection cn = new CreateConection();
    String qry = null;
    ResultSet rs = null;
    int completado = 1;

    public int idEmpleado;
    public String nombre;
    public String apellido;
    public String genero;
    public float salario;
    public String fechaNacimiento;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public int agregarEmpleado(String nombre, String apellido, String genero, float salario, Date fecha){
        Timestamp ts = new Timestamp(fecha.getTime());
        try {   
            qry = "CALL AGREGAR_EMPLEADO(?,?,?,?,?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setString(1, nombre);
            cs.setString(2, apellido);
            cs.setString(3, genero);
            cs.setFloat(4, salario);
            cs.setTimestamp(5, ts);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
    
        public int actualizarEmpleado(int id_empleado, String nombre, String apellido, String genero, float salario, Date fecha){
        Timestamp ts = new Timestamp(fecha.getTime());    
        try {
            qry = "CALL ACTUALIZAR_EMPLEADO(?,?,?,?,?,?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, id_empleado);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setString(4, genero);
            cs.setFloat(5, salario);
            cs.setTimestamp(6, ts);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
        
        
        public int eliminarEmpleado(int id_empleado){
        try {
            qry = "CALL ELIMINAR_EMPLEADO(?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, id_empleado);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }    
}
