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
public class TarjetaDeCredito extends Cuenta {
    
    //TODO: La Tarjeta de Credito empieza en negativo
    
    private final double interesRetirar = 0.1;
    
    private final double descubierto = 5000;
    
    private final String nombreTarjeta;

    public TarjetaDeCredito(int pNumeroCuenta, double pSaldo, String tarjeta) {
        super(pNumeroCuenta, pSaldo);
        nombreTarjeta = tarjeta;                
    }
    
    public double getInteresRetirar(){
        return interesRetirar;
    }
    
    public String getNombreTarjeta(){
        return nombreTarjeta;
    }

    @Override
    public boolean retirar(double pMonto) {
        boolean resultado = false;
        
        double saldoCalculado = descubierto + saldo;                
        
        if (pMonto <= saldoCalculado)
        {
            saldo -= pMonto + (pMonto * interesRetirar);
            resultado = true;
        }       

        return resultado;
    }
    
}
