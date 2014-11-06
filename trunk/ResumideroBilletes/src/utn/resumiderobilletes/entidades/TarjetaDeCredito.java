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
public class TarjetaDeCredito extends Cuenta implements Serializable {     

    private final String nombreTarjeta;    
    
    private double saldoGastado;    

    public double getSaldoGastado() {
        return saldoGastado;
    }

    public TarjetaDeCredito(int pNumeroCuenta, double pSaldo, String tarjeta) {
        super(pNumeroCuenta,pSaldo);
        nombreTarjeta = tarjeta;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    @Override
    public boolean retirar(double pMonto) {
        boolean resultado = false;

        double saldoCalculado = saldo - saldoGastado;

        if (pMonto <= saldoCalculado) {
            saldoGastado += pMonto;
            resultado = true;
        }
        return resultado;
    }
    
    @Override
    public void depositar(double pmonto){
        saldoGastado += pmonto;
    }

    @Override
    public String getTipo() {
        return TipoCuenta.TARJETADECREDITO.getDescripcion();
    }

}
