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
public abstract class Cuenta implements Comparable,Serializable {

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

        wRes.append("Nº:").append(numeroCuenta);
        wRes.append("\t - ").append(getTipo());
        wRes.append("\t - ").append(saldo);

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

    @Override
    public int compareTo(Object o) {
           int res;
        if (o instanceof Cuenta)
        {
            if (this.getNumeroCuenta() == ((Cuenta)o).getNumeroCuenta()){
                res = 0;
            }else if (this.getNumeroCuenta() > ((Cuenta)o).getNumeroCuenta()){
                res = 1;
            }else{
                res = -1;
            }            
        }
        else
            throw new RuntimeException("El tipo del objeto debe ser Cuenta.");
        
        return res;
    }
}
