/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utn.resumiderobilletes.repositorios;

import java.io.Serializable;
import utn.resumiderobilletes.entidades.Categoria;
import utn.resumiderobilletes.entidades.Cuenta;
import utn.resumiderobilletes.listas.ListaGenerica;

/**
 *
 * @author Luciano Ybañez
 */
public class Datos implements Serializable {

    private final ListaGenerica<Categoria> categorias;    
    
    private final ListaGenerica<Cuenta> cuentas;    

    public ListaGenerica<Cuenta> getCuentas() {
        return cuentas;
    }

    public ListaGenerica<Categoria> getCategorias() {
        return categorias;
    }
    
    public Datos() {
        cuentas = new ListaGenerica<>();
        categorias = new ListaGenerica<>();        
    }    
    
}
