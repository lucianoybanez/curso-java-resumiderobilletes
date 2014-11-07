/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utn.resumiderobilletes.ui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import utn.resumiderobilletes.repositorios.Archivo;
import utn.resumiderobilletes.ui.forms.FrmPrincipal;

/**
 *
 * @author libanez
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Archivo.cargarDatos();
        
         try {
            // Set cross-platform Java L&F (also called "Metal")
            
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        FrmPrincipal form = new FrmPrincipal();
        form.setVisible(true);
    }
    
}
