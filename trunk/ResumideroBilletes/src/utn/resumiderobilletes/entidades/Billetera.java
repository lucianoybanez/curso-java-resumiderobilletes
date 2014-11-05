/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.entidades;

import java.io.Serializable;

/**
 *
 * @author Luciano Ybañez
 */
public class Billetera extends Cuenta implements Serializable {

    private static final String TIPO = "Billetera";
    
    public Billetera(int pNumeroCuenta, double pSaldo) {
        super(pNumeroCuenta, pSaldo);
    }

    @Override
    public boolean retirar(double pMonto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTipo() {
        return TIPO;
    }

}
