/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Luciano Ybañez
 */
public class Archivo {
    
    private static final String RESUMIDERO_FILE = "..\\Resumidero.jdb";

    private static Datos datos;

    public static Datos getDatos() {
        if (datos == null) {
            cargarDatos();
        }
        return datos;
    }

    public static void cargarDatos() {        
        File f = new File(RESUMIDERO_FILE);
        if (f.exists()) {
            try {
                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);
                datos = (Datos) oi.readObject();
                oi.close();
                fi.close();
            } catch (IOException iOException) {
                iOException.printStackTrace();
                System.exit(1);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
                System.exit(2);
            }
        }else{
            datos = new Datos();
        }        
    }

    public static void guardar() {
        File f = new File(RESUMIDERO_FILE);

        try {
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(getDatos());
            oo.close();
            fo.close();
        } catch (IOException iOException) {
            System.out.println("No se pudo Guardar...");
        }

    }
}
