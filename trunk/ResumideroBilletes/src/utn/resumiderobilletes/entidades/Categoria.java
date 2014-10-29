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
public enum Categoria {
    ALIMENTO("Alimento"),
    IMPUESTO("Impuesto"),
    ENTRETENIMIENTO("Entretenimiento"),
    TRANSPORTE("Transporte"),
    ALQUILER("Alquiler"),
    RECREACION("Recreacion"),
    SALUD("Salud"),
    DEUDA("Deuda"),
    OTRO("Otro");
    
    private final String descripcion;
    
    public String getDescripcion(){
        return descripcion;
    }
    
    Categoria(String descripcion){
        this.descripcion = descripcion;
    }
    
}
