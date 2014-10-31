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
public class Movimiento {

    public Movimiento(int numero, Cuenta cuenta, Categoria categoria) {
        this.numero = numero;
        this.cuenta = cuenta;
        this.categoria = categoria;
    }
    
    private final int numero;

    public int getNumero() {
        return numero;
    }
    
    private Cuenta cuenta;
    
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }    
    
    @Override
    public boolean equals(Object o){
        if (o instanceof Movimiento){
            return ((Movimiento)o).getNumero() == this.getNumero();
        }
        return true;
    }    
}
