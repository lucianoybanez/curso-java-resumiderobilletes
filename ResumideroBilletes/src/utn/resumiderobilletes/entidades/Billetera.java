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
    
    public Billetera(int pNumeroCuenta, double pSaldo) {
        super(pNumeroCuenta, pSaldo);
    }

    @Override
    public boolean retirar(double pMonto) {
        saldo -= pMonto;
        return true;
    }

    @Override
    public String getTipo() {
        return TipoCuenta.BILLETERA.getDescripcion();
    }

}
