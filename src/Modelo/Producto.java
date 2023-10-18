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
public class Producto {
    Connection conn = null;
    PreparedStatement st = null;
    CallableStatement cs = null;
    CreateConection cn = new CreateConection();
    String qry = null;
    ResultSet rs = null;
    int completado = 1;
    
    public float barcodeId;
    public String descripcion;
    public int stock;
    public int stockMinimo;
    public int stockMaximo;
    public float precioUnitario;
    public int idProveedor;

    public float getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(float barcodeId) {
        this.barcodeId = barcodeId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdProveedorPorProducto(String nombre){
        int id = 0;
        try {
            qry = "SELECT DISTINCT(ID_PROV) AS ID FROM GET_PROVEEDORES() WHERE NOMBRE = ?";
            conn = cn.getConection();
            st = conn.prepareStatement(qry);
            st.setString(1, nombre);
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
    
    public int validarBarcode(int barcode){
        int existe = 0;
        try {
            qry = "SELECT BARCODE_ID AS EXISTE FROM GET_PRODUCTOS() WHERE BARCODE_ID = ?";
            conn = cn.getConection();
            st = conn.prepareStatement(qry);
            st.setInt(1, barcode);
            rs = st.executeQuery();
            while(rs.next()){
                existe++;
            }
            return existe;
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return existe;
        }
    }
    
    public int agregarProducto(int barcode, String descripcion, int stockMinimo, int stockMaximo, float precio, int proveedor){
        try {
            qry = "CALL AGREGAR_PRODUCTO(?,?,?,?,?,?,?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, barcode);
            cs.setString(2, descripcion);
            cs.setInt(3, 0);
            cs.setInt(4, stockMinimo);
            cs.setInt(5, stockMaximo);
            cs.setFloat(6, precio);
            cs.setInt(7, proveedor);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
    
    public int actualizarProducto(int barcode, String descripcion, int stockMinimo, int stockMaximo, float precio){
        try {
            qry = "CALL ACTUALIZAR_PRODUCTO(?,?,?,?,?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, barcode);
            cs.setString(2, descripcion);
            cs.setInt(3, stockMinimo);
            cs.setInt(4, stockMaximo);
            cs.setFloat(5, precio);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
    
    public int eliminarProducto(int idProducto){
        try {
            qry = "CALL ELIMINAR_PRODUCTO(?)";
            conn = cn.getConection();
            cs = conn.prepareCall(qry);
            cs.setInt(1, idProducto);
            completado = cs.executeUpdate();
            return completado;
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            return completado;
        }
    }
}
