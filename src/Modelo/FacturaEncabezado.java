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

/**
 *
 * @author Denis Arango
 */
public class FacturaEncabezado {
    Connection conn = null;
    PreparedStatement st = null;
    CallableStatement cs = null;
    CreateConection cn = new CreateConection();
    String qry = null;
    ResultSet rs = null;
    int completado = 1;
    
    public int idFactura;
    public int idCliente;
    public String nombre;
    public String direccion;
    public float monto;
    public Date fecha;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public int obtenerIdSiguienteFactura(){
        int id = 0;
        try {
            conn = cn.getConection();
            qry = "SELECT ID_FACTURA FROM FACTURA_ENCABEZADO ORDER BY ID_FACTURA DESC LIMIT 1";
            st = conn.prepareStatement(qry);
            rs = st.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1);
            }
            id += 1;
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaEncabezado.class.getName()).log(Level.SEVERE, null, ex);
            return id;
        } 
    }
    
    public int obtenerIdCliente(String[] datos){
        int id = 0;
        try {
            conn = cn.getConection();
            qry = "SELECT ID_CLIENTE FROM GET_CLIENTES() WHERE ";
            if(datos[0].equals(" ")){
                qry += "RAZON_SOCIAL = '" + datos[2] + "'";
            }else if(datos[2].equals(" ")){
                qry += "NOMBRE = '" + datos[0] + "' AND APELLIDO = '" + datos[1] + "'";
            }else{
                qry += "NOMBRE = '" + datos[0] + "' AND APELLIDO = '" + datos[1] + "' AND RAZON_SOCIAL = '" + datos[2] + "'";
            }
            st = conn.prepareStatement(qry);
            rs = st.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1);
            }
            
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaEncabezado.class.getName()).log(Level.SEVERE, null, ex);
            return id;
        }
    }
    
    public int agregarEncabezado(int idCliente, String cadena, float monto, String usuario){
        try {
            conn = cn.getConection();
            qry = "CALL AGREGAR_ENCABEZADO(?,?,?,?)";
            cs = conn.prepareCall(qry);
            cs.setInt(1, idCliente);
            cs.setString(2, cadena);
            cs.setFloat(3, monto);
            cs.setString(4, usuario);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaEncabezado.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
        
    }
    
}
