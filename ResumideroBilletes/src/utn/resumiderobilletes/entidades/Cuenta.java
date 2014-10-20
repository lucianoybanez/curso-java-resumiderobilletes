/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.entidades;

/**
 *
 * @author Luciano Ybañez
 */
public abstract class Cuenta
{

    private final int numeroCuenta;
    protected double saldo;

    public Cuenta(int pNumeroCuenta, double pSaldo)
    {
        numeroCuenta = pNumeroCuenta;
        saldo = pSaldo;        
    }
    
    public double consultarSaldo()
    {
        return saldo;
    }

    public void depositar(double pMonto)
    {
        saldo += pMonto;
    }

    public int getNumeroCuenta()
    {
        return numeroCuenta;
    }
    
    @Override
    public String toString()
    {
        StringBuilder wRes = new StringBuilder();
        
        wRes.append("\tNumero de Cuenta:\t").append(numeroCuenta);
        wRes.append("\n\tSaldo:\t").append(saldo);
      
        return wRes.toString();        
    }

    public abstract boolean retirar(double pMonto);    
}
