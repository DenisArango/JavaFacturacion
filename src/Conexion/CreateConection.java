/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Javier Ramírez
 */
public class CreateConection {
    static Properties props = new Properties();

    String hostname = null;
    String port = null;
    String database = null;
    String username = null;
    String password = null;
    String jndi  = null;
    
    public CreateConection (){
        InputStream in = null;
        try {
            
            in = Files.newInputStream(FileSystems.getDefault().getPath("C:\\Users\\flavi\\Documents\\Proyectofinalprogra\\JavaFacturacion\\src\\Conexion\\db_props.properties"));
            props.load(in);
            in.close();
            
        }catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try{
                in.close();
            }catch (IOException ex ) {
                ex.printStackTrace();
            }
        }
        loadProperties();
    }
    public void loadProperties(){
                hostname = props.getProperty("hostname");
                port  = props.getProperty("port");
                database = props.getProperty("database");
                username =   props.getProperty("username");
                password =   props.getProperty("password");
                jndi = props.getProperty("jndi");
        }
    
    public Connection getConection() throws SQLException{
    Connection conn = null;
    String jdbcUrl = "jdbc:postgresql://"+this.hostname+":"+
            this.port + "/" + this.database;
    
    conn = DriverManager.getConnection(jdbcUrl,username,password);
    System.out.println("Conexion establecida");
    
    return conn;
    }
    public Connection getDSConection(){
    Connection conn  = null;
    try{    Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup(this.jndi);
            conn = ds.getConnection();
        }catch(NamingException | SQLException ex){
            ex.printStackTrace();
            }
    return conn;
    }
    
    
}
