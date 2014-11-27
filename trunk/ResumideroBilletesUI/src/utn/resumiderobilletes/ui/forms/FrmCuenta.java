/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.ui.forms;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.util.List;
import javax.swing.JOptionPane;
import utn.resumiderobilletes.entidades.Billetera;
import utn.resumiderobilletes.entidades.CajaDeAhorro;
import utn.resumiderobilletes.entidades.Cuenta;
import utn.resumiderobilletes.entidades.TarjetaDeCredito;
import utn.resumiderobilletes.entidades.TipoCuenta;
import utn.resumiderobilletes.entidades.TipoCuenta.*;
import utn.resumiderobilletes.excepciones.ResumideroException;
import utn.resumiderobilletes.interfaces.In;
import utn.resumiderobilletes.listas.ListaGenerica;
import utn.resumiderobilletes.repositorios.Archivo;

/**
 *
 * @author Luciano
 */
public class FrmCuenta extends javax.swing.JFrame {

    ListaGenerica<Cuenta> cuentas = Archivo.getDatos().getCuentas();
    double monto = 0;
    private FrmPrincipal frmParent;

    /**
     * Creates new form FrmCuenta
     */
    public FrmCuenta() {
        initComponents();
        cargarDatosIniciales();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboCuenta = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblTarjeta = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Crear Cuenta");

        comboCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCuenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCuentaItemStateChanged(evt);
            }
        });
        comboCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCuentaActionPerformed(evt);
            }
        });
        comboCuenta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboCuentaPropertyChange(evt);
            }
        });
        comboCuenta.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                comboCuentaVetoableChange(evt);
            }
        });

        jLabel2.setText("Tipo:");

        jLabel3.setText("Monto inicial:");

        txtMonto.setToolTipText("");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblTarjeta.setText("Nombre de la Tarjeta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtMonto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(53, 53, 53)
                                .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(33, 33, 33)
                        .addComponent(lblTarjeta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton1)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTarjeta)
                    .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        lblTarjeta.getAccessibleContext().setAccessibleName("jbl4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String selected = (String) comboCuenta.getSelectedItem();
            boolean isNumber = isnumber(txtMonto.getText());
            TipoCuenta cmboitem = TipoCuenta.getByDescription(selected);
            if (isNumber) {
                Cuenta cta;
                int wNumero = cuentas.getCantidad() + 1;
                switch (cmboitem) {
                    case BILLETERA:
                        cta = new Billetera(wNumero, monto);
                        break;
                    case CAJADEAHORRO:
                        cta = new CajaDeAhorro(wNumero, monto);
                        break;
                    case TARJETADECREDITO:
                        if (txtTarjeta.getText().isEmpty()) {
                            throw new ResumideroException("El nombre de la tarjeta no puede ser vacio.");
                        }
                        cta = new TarjetaDeCredito(wNumero, monto, txtTarjeta.getText().toUpperCase().trim());
                        break;
                    default:
                        throw new ResumideroException("Problemas en metodo crearCuenta seleccionando el Tipo de Cuenta");
                }
                cuentas.agregar(cta);
                frmParent.iniciarFormulario();
                JOptionPane.showMessageDialog(this, "La cuenta se creo exitosamente!!!", "Error", JOptionPane.INFORMATION_MESSAGE);
                Archivo.guardar();
                this.dispose();
            } else {
                throw new ResumideroException("El monto tiene que ser un numero valido mayor que 0.");                
            }

        } catch (ResumideroException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCuentaActionPerformed


    }//GEN-LAST:event_comboCuentaActionPerformed

    private void comboCuentaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboCuentaPropertyChange


    }//GEN-LAST:event_comboCuentaPropertyChange

    private void comboCuentaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_comboCuentaVetoableChange

    }//GEN-LAST:event_comboCuentaVetoableChange

    private void comboCuentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCuentaItemStateChanged
        String selected = (String) comboCuenta.getSelectedItem();
        if (selected != null && !selected.isEmpty()) {
            TipoCuenta cmboitem = TipoCuenta.getByDescription(selected);
            if (cmboitem.equals(TipoCuenta.TARJETADECREDITO)) {
                setTarjetaVisible(true);
            } else {
                setTarjetaVisible(false);
            }
        }
    }//GEN-LAST:event_comboCuentaItemStateChanged

    private void setTarjetaVisible(boolean value) {
        txtTarjeta.setVisible(value);
        lblTarjeta.setVisible(value);
    }

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
            java.util.logging.Logger.getLogger(FrmCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboCuenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblTarjeta;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables

    private void cargarDatosIniciales() {
        txtMonto.setText("");
        cargarComboCuentas();
        setTarjetaVisible(false);
    }

    public void setPadre(FrmPrincipal pPadre) {
        frmParent = pPadre;
    }

    private void cargarComboCuentas() {
        comboCuenta.removeAllItems();
        comboCuenta.addItem(TipoCuenta.BILLETERA.getDescripcion());
        comboCuenta.addItem(TipoCuenta.CAJADEAHORRO.getDescripcion());
        comboCuenta.addItem(TipoCuenta.TARJETADECREDITO.getDescripcion());
        comboCuenta.repaint();
    }

    private boolean isnumber(String text) {
        try {
            monto = Double.valueOf(text);
            if (monto > 0) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
