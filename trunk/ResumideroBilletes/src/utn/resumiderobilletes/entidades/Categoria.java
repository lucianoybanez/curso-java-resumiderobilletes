/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utn.resumiderobilletes.entidades;

import java.io.Serializable;

/**
 *
 * @author libanez
 */
public class Categoria implements Serializable {

    private final String  descripcion;    
    
    private final  int id ;

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public Categoria(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
}
