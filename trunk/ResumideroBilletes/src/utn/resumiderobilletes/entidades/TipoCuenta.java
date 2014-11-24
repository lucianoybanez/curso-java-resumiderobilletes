/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.entidades;

import utn.resumiderobilletes.excepciones.ResumideroException;

/**
 *
 * @author Luciano Ybañez
 */
public enum TipoCuenta {

    CAJADEAHORRO("Caja de Ahorro"),
    BILLETERA("Billetera de bolsillo"),
    TARJETADECREDITO("Tarjeta de Credito");

    private final String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    TipoCuenta(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public static TipoCuenta getByDescription(String descripcion){
        for (TipoCuenta item : TipoCuenta.values()) {
            if (descripcion.equals(item.getDescripcion()))
            {
                return item;
            }
        }
        throw new ResumideroException("No se encuentra el tipo de cuenta");    
    }

}
