/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.listas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import utn.resumiderobilletes.entidades.Categoria;
import utn.resumiderobilletes.entidades.Cuenta;

/**
 *
 * @author libanez
 * @param <T>
 */
public class ListaGenerica<T> implements Iterable<T>, Serializable {

    private final LinkedList<T> items;

    private final HashMap<Integer, T> idxitems;

    public ListaGenerica() {
        items = new LinkedList<>();
        idxitems = new HashMap<>();
    }

    public void agregar(T value) {
        items.add(value);
        idxitems.put(getKey(value), value);
    }

    public int getCantidad() {
        return items.size();
    }

    public T getItem(int index) {
        if (index <= this.getCantidad()) {
            return items.get(index);
        }
        return null;
    }

    public T buscar(int value) {
        return idxitems.get(value);
    }

    private int getKey(T value) {
        if (value instanceof Cuenta) {
            return ((Cuenta) value).getNumeroCuenta();
        } else if (value instanceof Categoria) {
            return ((Categoria) value).getId();
        } else {
            return value.hashCode();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorLista();
    }

    private class IteratorLista implements Iterator<T> {

        private int actual;

        public IteratorLista() {
            actual = 0;
        }

        @Override
        public boolean hasNext() {
            return actual < getCantidad();
        }

        @Override
        public T next() {
            Object ret = null;
            if (hasNext()) {
                ret = getItem(actual);
            }
            actual++;
            return (T) ret;
        }

        @Override
        public void remove() {
            Object res = items.get(actual);
            items.remove(actual);
            idxitems.remove(getKey((T) res));
            actual--;
        }
    }
    
    public List<T> getTodos(){
        ArrayList<T> al = new ArrayList<>(new TreeSet(items));
        return al;
    }   
   
}
