/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.entidades;

import java.io.Serializable;
import java.util.List;
import utn.resumiderobilletes.listas.ListaGenerica;

/**
 *
 * @author Luciano Ybañez
 */
public class Categoria implements Filtrable, Serializable {

    private final String descripcion;

    private final int id;
    
    private ListaGenerica<Movimiento> movimientos;

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Categoria(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.movimientos = new ListaGenerica<>();
    }
    
    @Override
    public String toString(){
      
        String res = id + " - " + descripcion + " (" + movimientos.getCantidad() + ")";
        return res;
    }

    @Override
    public boolean pertenece(String pToken)
    {
        boolean wRes = false;
        if (descripcion.contains(pToken))
            wRes = true;        
        return wRes;
    }
    
    public List<Movimiento> getMovimientos()
    {
        return movimientos.getTodos();
    }
    
     public void agregar(Movimiento movimiento)
    {
        movimientos.agregar(movimiento);
    }
   
    

}
