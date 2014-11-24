/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.interfaces;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import utn.resumiderobilletes.entidades.Billetera;
import utn.resumiderobilletes.entidades.CajaDeAhorro;
import utn.resumiderobilletes.entidades.Categoria;
import utn.resumiderobilletes.entidades.Cuenta;
import utn.resumiderobilletes.entidades.Movimiento;
import utn.resumiderobilletes.entidades.TarjetaDeCredito;
import utn.resumiderobilletes.entidades.TipoCuenta;
import utn.resumiderobilletes.excepciones.ResumideroException;
import utn.resumiderobilletes.excepciones.ResumideroValidationException;
import utn.resumiderobilletes.listas.ListaGenerica;
import utn.resumiderobilletes.repositorios.Archivo;

/**
 *
 * @author Luciano Ybañez
 */
public class InterfazConsola  {
    
    private static final String tab = "\t";

    public boolean iniciar() {
        try {
            char opc;
            do {
                opc = menuPPal();
                switch (opc) {
                    case '1':
                        crearCuenta();
                        break;
                    case '2':
                        listarCuentas();
                        break;
                    case '3':
                        nuevoDeposito();
                        break;
                    case '4':
                        nuevoGasto();
                        break;                    
                    case '5':
                        listarMovimientos();
                        break;     
                    case '6':
                        iniciarCategorias();
                        break;
                    case '7':
                        listarMovimientosCategoria();
                        break;                    
                    case 'X':
                        salida();
                        break;
                    default:
                        System.out.println("");
                        System.out.println("Elija una opción válida...");
                        System.out.println("");
                }

            } while (opc != 'X');
        } catch (ResumideroValidationException e) {
            System.out.println("");
            System.out.println(e.getMessage());
            System.out.println("");
            return false;
        }
        return true;
    }

    public char menuPPal() {
        char opc;
        System.out.println("*** Menú Principal ***");
        System.out.println("1 - Crear Cuenta");
        System.out.println("2 - Listar Cuentas");
        System.out.println("3 - Nuevo Deposito");
        System.out.println("4 - Nuevo Gasto");        
        System.out.println("5 - Listar Movimientos");        
        System.out.println("6 - Menú Categorias");
        System.out.println("7 - Listar Movimientos por Categoria");        
        System.out.println("X - Salir");
        System.out.print("Ingrese Opcion: ");
        opc = Character.toUpperCase(In.readChar());
        return opc;
    }

    private void crearCuenta() throws ResumideroValidationException {
        ListaGenerica<Cuenta> lista = Archivo.getDatos().getCuentas();
        System.out.println("");
        System.out.println("Nuevo Cuenta");
        int wNumero = lista.getCantidad() + 1;
        System.out.println("Numero: " + wNumero);        
        System.out.print("Saldo: ");
        double wSaldo = In.readDouble();
        listarTiposDeCuenta();
        TipoCuenta tipoCuenta = seleccionarTiposDeCuenta();
        if (wSaldo > 0) {
            Cuenta cta;
            switch (tipoCuenta) {
                case BILLETERA:
                    cta = new Billetera(wNumero, wSaldo);
                    break;
                case CAJADEAHORRO:
                    cta = new CajaDeAhorro(wNumero, wSaldo);
                    break;
                case TARJETADECREDITO:
                    System.out.print("Nombre de la Tarjeta: ");
                    String wTarjeta = In.readLine();
                    cta = new TarjetaDeCredito(wNumero, wSaldo, wTarjeta);
                    break;
                default:
                    throw new ResumideroException("Problemas en metodo crearCuenta seleccionando el Tipo de Cuenta");
            }
            lista.agregar(cta);
            Archivo.guardar();
            System.out.println("Cuenta creada exitosamente!");
        } else {
            throw new ResumideroValidationException("No se creo la cuenta...");
        }
        System.out.println("");
    }

    private void listarTiposDeCuenta() {
        System.out.println("----Seleccione Tipo de Cuenta----");
        TipoCuenta[] valores = TipoCuenta.values();
        for (TipoCuenta tipo : valores) {
            System.out.println(tipo.ordinal() + " " + tipo.getDescripcion());
        }
    }

    private TipoCuenta seleccionarTiposDeCuenta() {
        TipoCuenta[] valores = TipoCuenta.values();
        int nro;
        do {
            System.out.print("Ingrese el tipo de Cuenta: ");
            nro = In.readInt();
        } while (nro < 0 || nro > valores.length);
        return valores[nro];
    }

    private void listarCuentas() {
        ListaGenerica<Cuenta> lista = Archivo.getDatos().getCuentas();
        System.out.println("");
        for (Cuenta cta : lista) {
            System.out.println("Numero: " + cta.getNumeroCuenta() + "\t Saldo:" + cta.getSaldo()+ "\t Tipo:" + cta.getTipo());
        }
        System.out.println("Cantidad de Cuentas: " + lista.getCantidad());
        System.out.println("");
        In.readLine();
    }

    private void crearMovimiento(boolean isDeposito) throws ResumideroValidationException {
        ListaGenerica<Movimiento> listaMoviminentos = Archivo.getDatos().getMovimientos();
        ListaGenerica<Cuenta> listaCuentas = Archivo.getDatos().getCuentas();
        System.out.println("");        
        System.out.print("Numero de Cuenta: ");
        int wCuenta = In.readInt();        
        Categoria cat = selectorCategoria();
        System.out.print("Monto: ");
        double wMonto = In.readDouble();        
        Cuenta cuenta = listaCuentas.buscar(wCuenta);
        if (cuenta != null && cat != null && wMonto > 0) {
            boolean retirar;
            if (isDeposito) {
                cuenta.depositar(wMonto);
            } else {
                retirar = cuenta.retirar(wMonto);
                if (!retirar){
                    throw new ResumideroValidationException("No se pudo retirar el dinero");
                }
            }
            int numeroMovimineto = listaMoviminentos.getCantidad() + 1;
            Movimiento mov = new Movimiento(numeroMovimineto,wCuenta, cat.getId(), wMonto, isDeposito);
            listaMoviminentos.agregar(mov);
            cat.agregar(mov);
            Archivo.guardar();
            System.out.println("Movimiento creado exitosamente!");
        } else {
            throw new ResumideroValidationException("No se creo el movimiento, posibles problemas \n La cuenta debe existir \n La Categoria debe existir \n El monto tiene q ser mayor a 0");
        }
        System.out.println("");
    }
    
    private void nuevoGasto() throws ResumideroValidationException{
        crearMovimiento(false);
    }
    
    private void nuevoDeposito() throws ResumideroValidationException{    
        crearMovimiento(true);
    }

    private void listarMovimientos() {
        ListaGenerica<Movimiento> lista = Archivo.getDatos().getMovimientos();
        System.out.println("");
        for (Movimiento mov : lista) {
            printMovimiento(mov);                   
        }
        System.out.println("Cantidad de Movimientos: " + lista.getCantidad());
        System.out.println("");
        In.readLine();
    }
    
    private void listarMovimientosCategoria() {
        ListaGenerica<Categoria> listaCategorias = Archivo.getDatos().getCategorias();
        ListaGenerica<Movimiento> listaMovimientos = Archivo.getDatos().getMovimientos();
        System.out.println("");        
        
        for (Iterator it = listaCategorias.iterator(); it.hasNext();) {
            Categoria cat = (Categoria)it.next();
            System.out.println("Categoria: " + cat.getDescripcion());
            System.out.println("FECHA" + tab + "NUMERO" + tab + "OPERACION" + tab + "CUENTA" + tab + "MONTO");        
            for (Movimiento mov : listaMovimientos) {
                if (mov.getCategoria() == cat.getId()){
                    printMovimiento(mov);                   
                }                
            }            
        }        
        System.out.println("");
        In.readLine();
    }
    
    private void printMovimiento(Movimiento mov){
        
        String wfecha = toStringDate(mov.getFechaMovimiento());
        String wNumero = String.valueOf(mov.getNumero());
        String wCuenta = String.valueOf(mov.getCuenta());
        String wMonto = String.valueOf(mov.getMonto());
        String wTipo = mov.isDeposito() ? "DEPOSITO" : "GASTO";        
        System.out.println(wfecha + tab + wNumero + tab + wTipo + tab + wCuenta + tab + wMonto);        
    }

    private char menuCategorias() {
        char opc;
        System.out.println("*** Menú Categorias ***");
        System.out.println("1 - Crear Categoria");
        System.out.println("2 - Listar Categorias");
        System.out.println("V - Volver");
        System.out.print("Ingrese Opcion: ");
        opc = Character.toUpperCase(In.readChar());

        return opc;
    }

    private void salida() {
        System.out.println("Guardando datos...");
        Archivo.guardar();
        System.out.println("Fin!");
    }

    public Categoria selectorCategoria() {
        listarCategorias();
        ListaGenerica<Categoria> lista = Archivo.getDatos().getCategorias();
        Categoria res = null;
        if (lista.getCantidad() > 0) {
            System.out.println("0 - Cancelar");
            int nro;
            do {
                System.out.print("Ingrese el número de categoría: ");
                nro = In.readInt();
                if (nro != 0) {
                    res = lista.buscar(nro);
                }
            } while (nro != 0 && res == null);
        } else {
            System.out.println("No hay categorias creadas");
        }
        return res;
    }

    private void iniciarCategorias() throws ResumideroValidationException {
        char opc;
        do {
            opc = menuCategorias();
            switch (opc) {
                case '1':
                    crearCategoria();
                    break;
                case '2':
                    listarCategorias();
                    break;
                default:
                    System.out.println("");
                    System.out.println("Ingrese una opción válida");
                    System.out.println("");
            }
        } while (opc != 'V');
    }

    private void crearCategoria() throws ResumideroValidationException {
        ListaGenerica<Categoria> lista = Archivo.getDatos().getCategorias();
        System.out.println("");
        System.out.println("Nueva Categoría");
        System.out.print("Nombre: ");
        String nombre = In.readLine();
        if (!nombre.isEmpty()) {
            int nro = lista.getCantidad() + 1;
            lista.agregar(new Categoria(nro, nombre));
            Archivo.guardar();
            System.out.println("Categoria creada!");
        } else {
            throw new ResumideroValidationException("No se creo la categoría");
        }
        System.out.println("");
    }

    private void listarCategorias() {
        ListaGenerica<Categoria> lista = Archivo.getDatos().getCategorias();
        System.out.println("");
        for (Categoria categoria : lista) {
            System.out.println(categoria.getId() + " - " + categoria.getDescripcion());
        }
        System.out.println("Cantidad de Categorias: " + lista.getCantidad());
        System.out.println("");
    }

    private void importarResumidero() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void exportarResumidero() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    private String toStringDate(Date fecha){
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
        return df.format(fecha);
    }
    
}
