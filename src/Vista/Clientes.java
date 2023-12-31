/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexion.CreateConection;
import Modelo.Cliente;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Denis Arango
 */
public class Clientes extends javax.swing.JFrame {

    
    Inicio vInicio;
    Connection conn = null;
    PreparedStatement st = null;
    CreateConection cn = new CreateConection();
    String qry = null;
    ResultSet rs = null;
    Cliente cl = new Cliente();
    
    public Clientes() {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setTitle("Lista de clientes");
        prepararBotones();
        cargarClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnGuardarCambios = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtNit = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();

        jButton2.setText("jButton2");

        jLabel4.setText("Direccion:");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaClientes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tablaClientesAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tablaClientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaClientesFocusGained(evt);
            }
        });
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaClientesMousePressed(evt);
            }
        });
        tablaClientes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablaClientesPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        btnGuardarCambios.setForeground(new java.awt.Color(240, 240, 240));
        btnGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel11.setText("Nombre:");

        jLabel12.setText("Apellido:");

        jLabel13.setText("Razon Social:");

        jLabel14.setText("Nit:");

        jLabel15.setText("Direccion:");

        jLabel16.setText("Telefono:");

        jLabel17.setText("Email:");

        jLabel18.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClientesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaClientesFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaClientesFocusGained

    private void tablaClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMousePressed
       if(evt.getClickCount() == 1){
            cl.setIdCliente(Integer.parseInt(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString()));
            txtNombre.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 1).toString());
            txtApellido.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 2).toString());
            txtRazonSocial.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 3).toString());
            txtNit.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 4).toString());
            txtDireccion.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 5).toString());
            txtTelefono.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 6).toString());
            txtEmail.setText(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 7).toString());
            if(Integer.parseInt(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 9).toString()) == 0){
                cmbEstado.setSelectedIndex(0);
            }else{
                cmbEstado.setSelectedIndex(1);
            }
       }
    }//GEN-LAST:event_tablaClientesMousePressed

    private void tablaClientesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablaClientesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaClientesPropertyChange

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String razonSocial = txtRazonSocial.getText();
        String nit = txtNit.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        int estado = cmbEstado.getSelectedIndex();

        if(nit.equals("") || direccion.equals("") || telefono.equals("") || email.equals("") || cmbEstado.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Debe llenar los campos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(razonSocial.equals("") && (nombre.equals("") || apellido.equals(""))){
            JOptionPane.showMessageDialog(null, "Debe tener una persona o razon social", "Error", JOptionPane.ERROR_MESSAGE);
        }else if((!nombre.equals("") && apellido.equals("")) || (nombre.equals("") && !apellido.equals(""))){
            JOptionPane.showMessageDialog(null, "Si la razon social tiene nombre, debe agregar un apellido o viceversa", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            if(cl.getIdCliente() == 0){
                if(cl.agregarCliente(nombre, apellido, razonSocial, nit, direccion, telefono, email, estado) == 0){
                    limpiarCampos();
                    cargarClientes();
                    JOptionPane.showMessageDialog(null, "Se agregó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Fallo al intentar agregar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                if(cl.actualizarCliente(cl.getIdCliente(), nombre, apellido, razonSocial, nit, direccion, telefono, email, estado) == 0){
                    limpiarCampos();
                    cargarClientes();
                    JOptionPane.showMessageDialog(null, "Se actualizó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Fallo al intentar actualizar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(cl.getIdCliente() == 0){
            JOptionPane.showMessageDialog(null, "Ningun registro seleccionado para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro?" ,"Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(confirmar == JOptionPane.YES_OPTION){
                if(cl.eliminarCliente(cl.getIdCliente()) == 0){
                    limpiarCampos();
                    cargarClientes();
                    JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Fallo al intentar eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void tablaClientesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablaClientesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaClientesAncestorAdded

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }
    
    private void cargarClientes(){
        try {
            conn = cn.getConection();
            qry = "SELECT * FROM GET_CLIENTES()";
            st = conn.prepareStatement(qry);
            rs = st.executeQuery();
            
            DefaultTableModel model = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
            
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Razon Social");
            model.addColumn("Nit");
            model.addColumn("Direccion");
            model.addColumn("Telefono");
            model.addColumn("Email");
            model.addColumn("Fecha de Creacion");
            model.addColumn("Estado");
            tablaClientes.setModel(model);
            
            String [] datos = new String[10];
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);    
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                model.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void prepararBotones(){
        btnGuardarCambios.setForeground(Color.red);
        btnGuardarCambios.setFocusPainted(false);
        btnGuardarCambios.setBorderPainted(false);
        btnGuardarCambios.setContentAreaFilled(false);
        ImageIcon guardarCambios = new ImageIcon(convertFile("src/iconos/GuardarCambios.png").toString());
        btnGuardarCambios.setIcon(new ImageIcon(guardarCambios.getImage().getScaledInstance(btnGuardarCambios.getWidth(), btnGuardarCambios.getHeight(), Image.SCALE_AREA_AVERAGING)));
        btnEliminar.setForeground(Color.red);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        ImageIcon eliminarRegistro = new ImageIcon(convertFile("src/iconos/EliminarRegistro.png").toString());
        btnEliminar.setIcon(new ImageIcon(eliminarRegistro.getImage().getScaledInstance(btnEliminar.getWidth(), btnEliminar.getHeight(), Image.SCALE_AREA_AVERAGING)));
        btnNuevo.setForeground(Color.red);
        btnNuevo.setFocusPainted(false);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        ImageIcon nuevoRegistro = new ImageIcon(convertFile("src/iconos/NuevoRegistro.png").toString());
        btnNuevo.setIcon(new ImageIcon(nuevoRegistro.getImage().getScaledInstance(btnNuevo.getWidth(), btnNuevo.getHeight(), Image.SCALE_AREA_AVERAGING)));
        DefaultComboBoxModel modelcmb = new DefaultComboBoxModel();
        modelcmb.addElement("Inactivo");
        modelcmb.addElement("Activo");
        cmbEstado.setModel(modelcmb);
        cmbEstado.setSelectedItem(null);
    }
    
    private void limpiarCampos(){
        cl.setIdCliente(0);
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtRazonSocial.setText(null);
        txtNit.setText(null);
        txtDireccion.setText(null);
        txtTelefono.setText(null);
        txtEmail.setText(null);
        cmbEstado.setSelectedItem(null);
    }
    
    private Path convertFile(String archivo){
        String path = new File(archivo).getAbsolutePath();
        return Paths.get(path);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
