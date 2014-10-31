/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utn.resumiderobilletes.entidades;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author libanez
 * @param <T>
 */
public class Lista<T> implements Iterable<T>,Serializable {    
    
    private final LinkedList<T> items;
    
    private final HashMap<Integer,T> idxitems;
    
    public Lista() {
        items = new LinkedList<>();
        idxitems = new HashMap<>();
    }
    
    public void agregar(T value){
        items.add(value);        
        if (value instanceof Cuenta){
            idxitems.put(((Cuenta)value).getNumeroCuenta(), value);
        } else if(value instanceof Categoria)  {        
            idxitems.put(((Categoria)value).getId(), value);
        } else {
            idxitems.put(value.hashCode(), value);
        }    
    }
    
    public int getCantidad(){
        return items.size();
    }
    
    public T getItem(int index){        
        if (index<= this.getCantidad()){
            return items.get(index);
        }
        return null;        
    }
    
    public T buscar(int value){
        return idxitems.get(value);
    }
    
    
    

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
