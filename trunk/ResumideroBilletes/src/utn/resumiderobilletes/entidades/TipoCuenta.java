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
public enum TipoCuenta {
    CAJADEAHORRO("Caja de Ahorro"),
    BILLETERA("Billetera de bolsillo"),
    TARJETADECREDITO("Tarjeta de Credito");    
    
    private final String descripcion;
    
    public String getDescripcion(){
        return descripcion;
    }
    
    TipoCuenta(String descripcion){
        this.descripcion = descripcion;
    }
    
}
