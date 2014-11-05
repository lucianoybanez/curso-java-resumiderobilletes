/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.interfaces;

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
public class InterfazConsola {

    public boolean iniciar() {        
        try {
            char opc;
            do {
                opc = menuPPal();
                switch (opc) {
                    case '0':
                        crearCuenta();
                        break;
                    case '1':
                        crearMovimiento();
                        break;
                    case '2':
                        listarMovimientos();
                        break;
                    case '6':
                        iniciarCategorias();
                        break;
                    case '7':
                        importarResumidero();
                        break;
                    case '8':
                        exportarResumidero();
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
        System.out.println("0 - Crear Cuenta");
        System.out.println("1 - Crear Movimiento");
        System.out.println("2 - Listar Movimientos");
        System.out.println("6 - Menú Categorias");
        System.out.println("7 - Importar Resumidero");
        System.out.println("8 - Exportar Resumidero");
        System.out.println("X - Salir");
        System.out.print("Ingrese Opcion: ");
        opc = Character.toUpperCase(In.readChar());
        return opc;
    }

    private void crearCuenta() throws ResumideroValidationException {
        ListaGenerica<Cuenta> lista = Archivo.getDatos().getCuentas();
        System.out.println("");
        System.out.println("Nuevo Cuenta");
        System.out.print("Numero: ");
        String wNumero = In.readLine();
        System.out.print("Saldo: ");
        String wSaldo = In.readLine();
        listarTiposDeCuenta();
        TipoCuenta tipoCuenta = seleccionarTiposDeCuenta();
        if (!wNumero.isEmpty() && (!wSaldo.isEmpty())) {
            Cuenta cta;
            switch (tipoCuenta) {
                case BILLETERA:
                    cta = new Billetera(Integer.valueOf(wNumero), Double.valueOf(wSaldo));
                    break;
                case CAJADEAHORRO:
                    cta = new CajaDeAhorro(Integer.valueOf(wNumero), Double.valueOf(wSaldo));
                    break;
                case TARJETADECREDITO:
                    System.out.print("Nombre de la Tarjeta: ");
                    String wTarjeta = In.readLine();
                    cta = new TarjetaDeCredito(Integer.valueOf(wNumero), Double.valueOf(wSaldo), wTarjeta);
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
        System.out.print("Seleccione Tipo de Cuenta: ");
        TipoCuenta[] valores = TipoCuenta.values();
        for (TipoCuenta tipo : valores) {
            System.out.print(tipo.ordinal() + " " + tipo.getDescripcion());
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

    private void crearMovimiento() throws ResumideroValidationException {
        ListaGenerica<Movimiento> listaMoviminentos = Archivo.getDatos().getMovimientos();
        ListaGenerica<Cuenta> listaCuentas = Archivo.getDatos().getCuentas();
        System.out.println("");
        System.out.println("Nuevo Movimiento");
        System.out.print("Numero de Cuenta: ");
        int wCuenta = In.readInt();
        listarCategorias();
        Categoria cat = selectorCategoria();
        System.out.print("Monto: ");
        double wMonto = In.readDouble();
        System.out.print("Deposito: 'D' - Extraccion: 'E' ");
        char deposito = In.readChar();
        boolean isDeposito = deposito == 'D';
        Cuenta cuenta = listaCuentas.buscar(wCuenta);
        if (cuenta != null && cat != null && wMonto > 0) {
            boolean retirar = false;
            if (isDeposito) {
                cuenta.depositar(wMonto);
            } else {
                retirar = cuenta.retirar(wMonto);
            }
            if (!isDeposito && !retirar) {
                throw new ResumideroValidationException("No se pudo retirar el dinero");
            }
            Movimiento mov = new Movimiento(wCuenta, cat.getId(), wMonto, isDeposito);
            listaMoviminentos.agregar(mov);
            Archivo.guardar();
            System.out.println("Movimiento creado exitosamente!");
        } else {
            throw new ResumideroValidationException("No se creo el movimiento");
        }
        System.out.println("");
    }

    private void listarMovimientos() {
        ListaGenerica<Movimiento> lista = Archivo.getDatos().getMovimientos();
        System.out.println("");
        System.out.println(lista);
        System.out.println("");
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

    public Categoria selectorCategoria() throws ResumideroValidationException {
        ListaGenerica<Categoria> lista = Archivo.getDatos().getCategorias();
        Categoria res = null;
        if (lista.getCantidad() > 0) {
            System.out.println(lista);
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
            throw new ResumideroValidationException("No hay categorias creadas");
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
        System.out.println(lista);
        System.out.println("");
    }

    private void importarResumidero() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void exportarResumidero() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
