/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.entidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Luciano Ybañez
 */
public class Movimiento implements Serializable, Comparable {

    private final Date fechaMovimiento;

    private final int numero;

    private int cuenta;

    private int categoria;

    private double monto;

    private final boolean deposito;

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public boolean isDeposito() {
        return deposito;
    }

    public double getMonto() {
        return monto;
    }

    public int getNumero() {
        return numero;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Movimiento(int numero, int cuenta, int categoria, double monto, boolean deposito) {
        this.fechaMovimiento = new Date();
        this.numero = numero;
        this.cuenta = cuenta;
        this.categoria = categoria;
        this.monto = monto;
        this.deposito = deposito;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Movimiento) {
            return ((Movimiento) o).getNumero() == this.getNumero();
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
         int res;
        if (o instanceof Movimiento)
        {
            
            res = this.fechaMovimiento.compareTo(((Movimiento) o).getFechaMovimiento());
        }
        else
            throw new RuntimeException("El tipo del objeto debe ser Movimiento.");
        
        return res;
    }
}
