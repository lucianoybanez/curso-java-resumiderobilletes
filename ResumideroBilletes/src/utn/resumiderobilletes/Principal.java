/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utn.resumiderobilletes;

import utn.resumiderobilletes.interfaces.InterfazConsola;

/**
 *
 * @author luciano Ybañez
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean salida;
        InterfazConsola consola = new InterfazConsola();                        
        do {            
            salida = consola.iniciar();
        } while (!salida);
        
    }
    
}
