/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utn.resumiderobilletes.entidades;

/**
 *
 * @author Luciano Ybañez
 */
public class CajaDeAhorro extends Cuenta {

    public CajaDeAhorro(int pNumeroCuenta, double pSaldo) {
        super(pNumeroCuenta, pSaldo);
    }

    @Override
    public boolean retirar(double pMonto) {
        
        boolean result = false;        
        if (pMonto <= saldo)
        {
            saldo -= pMonto;
            result = true;
        }        

        return result;
    }
    
}
