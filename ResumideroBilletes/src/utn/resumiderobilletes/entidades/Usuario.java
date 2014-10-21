/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.entidades;

import java.util.LinkedList;

/**
 *
 * @author Luciano Ybañez
 */
public class Usuario 
{
    private final int numero;
    private String nombre;
    private LinkedList<Cuenta> cuentas;
    
    public Usuario(int numero, String nombre, Cuenta cuenta)
    {
        this.numero = numero;
        this.nombre = nombre;
        cuentas.add(cuenta);
    }

    public int getNumero()
    {
        return numero;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String mNombre)
    {
        this.nombre = mNombre;
    }
    
    public Cuenta getCuenta(int position)
    {
        if (position >= 0 && position < getCantidadCuentas()){
            return cuentas.get(position);
        }        
        return null;
    }
    
    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }
    
    public int getCantidadCuentas(){
        return cuentas.size();
    }
    
    public int getCantidadTajetasDeCredito(){
        int tarjetas=0;
        for (Cuenta cuenta : cuentas) {
            if(cuenta instanceof TarjetaDeCredito){
                tarjetas ++;
            }
        }
        return tarjetas;
    }
    
    public double getTotalFondos(){
        double total = 0;
        for (Cuenta cuenta : cuentas) {
            total += cuenta.getSaldo();
        }
        return total;
    }
    
    @Override
    public String toString()
    {
       StringBuilder resutltado = new StringBuilder();
       
       resutltado.append("******** USUARIO  **********");
       resutltado.append("\nNumero:\t" + numero);
       resutltado.append("\nNombre:\t" + nombre);
               
       for (Cuenta cuenta : cuentas) {
           resutltado.append("\nCuenta:\n").append(cuenta.toString());
       }       
       resutltado.append("\nTotales:");
       resutltado.append("\nCantidad de Cuentas:\t" + getCantidadCuentas());
       resutltado.append("\nCantidad de Tarjetas de Credito:\t" + getCantidadTajetasDeCredito());
       resutltado.append("\nTotal de Fondos:\t" + getTotalFondos());
       
       resutltado.append("\n******** FIN USUARIO *******");
       
       return resutltado.toString();
       
    }       
    
}
