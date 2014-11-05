/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.entidades;

import java.io.Serializable;

/**
 *
 * @author Luciano Ybañez
 */
public abstract class Cuenta implements Serializable {

    private final int numeroCuenta;
    protected double saldo;

    public Cuenta(int pNumeroCuenta, double pSaldo) {
        numeroCuenta = pNumeroCuenta;
        saldo = pSaldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double pMonto) {
        saldo += pMonto;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public String toString() {
        StringBuilder wRes = new StringBuilder();

        wRes.append("\tNumero de Cuenta:\t").append(numeroCuenta);
        wRes.append("\n\tSaldo:\t").append(saldo);

        return wRes.toString();
    }

    public abstract boolean retirar(double pMonto);

    public abstract String getTipo();
    
    public boolean transferir(double pMonto, Cuenta pCuenta) {
        boolean retiro = this.retirar(pMonto);
        if (retiro) {
            pCuenta.depositar(pMonto);
        }
        return retiro;
    }
}
