/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Usuario;

/**
 *
 * @author Denis Arango
 */
public class Inicio extends javax.swing.JFrame {

    Usuario mod;
    Inicio vInicio;
    Proveedores vProveedores;
    Clientes vClientes;
    Productos vProductos;
    Usuarios vUsuarios;
    Empleados vEmpleados;
    Transacciones vTrans;   
    
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setTitle("Menú");
    }

    public Inicio(Usuario mod){
        initComponents();
        this.setLocationRelativeTo(null); 
        this.mod = mod;
        
        switch(mod.getIdRol()){
            case 1:
                break;
            case 2:
                opNuevaFactura.setVisible(false);
                menProveedores.setVisible(false);
                menClientes.setVisible(false);
                menProductos.setVisible(false);
                break;
            case 3:
                menEmpleados.setVisible(false);
                menUsuarios.setVisible(false);
                menTrans.setVisible(false);
                break;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menFacturas = new javax.swing.JMenu();
        opNuevaFactura = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menProductos = new javax.swing.JMenu();
        opListaProductos = new javax.swing.JMenuItem();
        menClientes = new javax.swing.JMenu();
        opListaClientes = new javax.swing.JMenuItem();
        menProveedores = new javax.swing.JMenu();
        opListaProveedores = new javax.swing.JMenuItem();
        menUsuarios = new javax.swing.JMenu();
        opListaUsuarios = new javax.swing.JMenuItem();
        menEmpleados = new javax.swing.JMenu();
        opListaEmpleados = new javax.swing.JMenuItem();
        menTrans = new javax.swing.JMenu();
        opListaTransacciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menFacturas.setText("Facturas");

        opNuevaFactura.setText("Nueva Factura");
        menFacturas.add(opNuevaFactura);

        jMenuItem2.setText("Consultar Facturas");
        menFacturas.add(jMenuItem2);

        jMenuBar1.add(menFacturas);

        menProductos.setText("Productos");

        opListaProductos.setText("Lista de Productos");
        opListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opListaProductosActionPerformed(evt);
            }
        });
        menProductos.add(opListaProductos);

        jMenuBar1.add(menProductos);

        menClientes.setText("Clientes");

        opListaClientes.setText("Lista de Clientes");
        opListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opListaClientesActionPerformed(evt);
            }
        });
        menClientes.add(opListaClientes);

        jMenuBar1.add(menClientes);

        menProveedores.setText("Proveedores");

        opListaProveedores.setText("Lista Proveedores");
        opListaProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opListaProveedoresActionPerformed(evt);
            }
        });
        menProveedores.add(opListaProveedores);

        jMenuBar1.add(menProveedores);

        menUsuarios.setText("Usuarios");

        opListaUsuarios.setText("Lista Usuarios");
        opListaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opListaUsuariosActionPerformed(evt);
            }
        });
        menUsuarios.add(opListaUsuarios);

        jMenuBar1.add(menUsuarios);

        menEmpleados.setText("Empleados");

        opListaEmpleados.setText("Lista empleados");
        opListaEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opListaEmpleadosActionPerformed(evt);
            }
        });
        menEmpleados.add(opListaEmpleados);

        jMenuBar1.add(menEmpleados);

        menTrans.setText("Transacciones");

        opListaTransacciones.setText("Lista Transacciones");
        opListaTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opListaTransaccionesActionPerformed(evt);
            }
        });
        menTrans.add(opListaTransacciones);

        jMenuBar1.add(menTrans);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opListaClientesActionPerformed
        vClientes = new Clientes();
        vClientes.setVisible(true);
    }//GEN-LAST:event_opListaClientesActionPerformed

    private void opListaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opListaProveedoresActionPerformed
        vProveedores = new Proveedores();
        vProveedores.setVisible(true);
    }//GEN-LAST:event_opListaProveedoresActionPerformed

    private void opListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opListaProductosActionPerformed
        vProductos = new Productos(mod);
        vProductos.setVisible(true);
    }//GEN-LAST:event_opListaProductosActionPerformed

    private void opListaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opListaUsuariosActionPerformed
        vUsuarios = new Usuarios();
        vUsuarios.setVisible(true);
    }//GEN-LAST:event_opListaUsuariosActionPerformed

    private void opListaEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opListaEmpleadosActionPerformed
        vEmpleados = new Empleados();
        vEmpleados.setVisible(true);
    }//GEN-LAST:event_opListaEmpleadosActionPerformed

    private void opListaTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opListaTransaccionesActionPerformed
        vTrans = new Transacciones();
        vTrans.setVisible(true);
    }//GEN-LAST:event_opListaTransaccionesActionPerformed

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu menClientes;
    private javax.swing.JMenu menEmpleados;
    private javax.swing.JMenu menFacturas;
    private javax.swing.JMenu menProductos;
    private javax.swing.JMenu menProveedores;
    private javax.swing.JMenu menTrans;
    private javax.swing.JMenu menUsuarios;
    private javax.swing.JMenuItem opListaClientes;
    private javax.swing.JMenuItem opListaEmpleados;
    private javax.swing.JMenuItem opListaProductos;
    private javax.swing.JMenuItem opListaProveedores;
    private javax.swing.JMenuItem opListaTransacciones;
    private javax.swing.JMenuItem opListaUsuarios;
    private javax.swing.JMenuItem opNuevaFactura;
    // End of variables declaration//GEN-END:variables
}
