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
public class FacturaDetalle {
    
    Connection conn = null;
    PreparedStatement st = null;
    CallableStatement cs = null;
    CreateConection cn = new CreateConection();
    String qry = null;
    ResultSet rs = null;
    int completado = 1;
    
    public int facturaDetalleId;
    public int facturaEncabezadoId;
    public int barcodeId;
    public float qty;
    public float precio;
    public float subtotal;

    public int getFacturaDetalleId() {
        return facturaDetalleId;
    }

    public void setFacturaDetalleId(int facturaDetalleId) {
        this.facturaDetalleId = facturaDetalleId;
    }

    public int getFacturaEncabezadoId() {
        return facturaEncabezadoId;
    }

    public void setFacturaEncabezadoId(int facturaEncabezadoId) {
        this.facturaEncabezadoId = facturaEncabezadoId;
    }

    public int getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(int barcodeId) {
        this.barcodeId = barcodeId;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
    public int agregarDetalle(int idFactura, int barcode, int qty, float precio, float subtotal, String usuario){
        try {
            conn = cn.getConection();
            qry = "CALL AGREGAR_DETALLE(?,?,?,?,?,?)";
            cs = conn.prepareCall(qry);
            cs.setInt(1, idFactura);
            cs.setInt(2, barcode);
            cs.setInt(3, qty);
            cs.setFloat(4, precio);
            cs.setFloat(5, subtotal);
            cs.setString(6, usuario);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
}
