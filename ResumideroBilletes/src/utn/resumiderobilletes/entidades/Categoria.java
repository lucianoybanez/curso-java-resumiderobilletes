/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.entidades;

import java.io.Serializable;

/**
 *
 * @author Luciano Ybañez
 */
public class Categoria implements Filtrable, Serializable {

    private final String descripcion;

    private final int id;

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
    
    @Override
    public String toString(){
        return id + " - " + descripcion;
    }

    @Override
    public boolean pertenece(String pToken)
    {
        boolean wRes = false;
        if (descripcion.contains(pToken))
            wRes = true;        
        return wRes;
    }
    

}
