/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.interfaces;
import java.util.LinkedList;
import utn.resumiderobilletes.entidades.CajaDeAhorro;
import utn.resumiderobilletes.entidades.Cuenta;
import utn.resumiderobilletes.listas.ListaGenerica;
import utn.resumiderobilletes.repositorios.Archivo;

/**
 *
 * @author Luciano Ybañez
 */
public class InterfazConsola
{

    public void iniciar()
    {
        char opc;
        do
        {
            opc = menuPPal();
            switch (opc)
            {
                case '0':
                    crearCuenta();
                    break;
                case '1':
                    crearMovimiento();                    
                    break;
                case '2':
                    listarMovimientos();
                    break;
                case '3':
                    buscarMovimiento();
                    break;
                case '4':
                    filtrarMovimientos();
                    break;
                case '5':
                    verCategoria();
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

        }
        while (opc != 'X');


    }

    public char menuPPal()
    {
        char opc;
        System.out.println("*** Menú Principal ***");
        System.out.println("0 - Crear Cuenta");
        System.out.println("1 - Crear Movimiento");
        System.out.println("2 - Listar Movimientos");
        System.out.println("3 - Buscar Movimiento");
        System.out.println("4 - Filtrar Movimiento");
        System.out.println("5 - Ver una Categoria");
        System.out.println("6 - Menú Categorias");
        System.out.println("7 - Importar Resumidero");
        System.out.println("8 - Exportar Resumidero");
        System.out.println("X - Salir");
        System.out.print("Ingrese Opcion: ");
        opc = Character.toUpperCase(In.readChar());
        return opc;
    }

    private void crearCuenta()
    {
        ListaGenerica<Cuenta> lista = Archivo.getDatos().getCuentas();
        System.out.println("");
        System.out.println("Nuevo Cuenta");
        System.out.print("Numero: ");
        String wNumero = In.readLine();
        System.out.print("Saldo: ");
        String wSaldo = In.readLine();        
        if (!wNumero.isEmpty() && (!wSaldo.isEmpty()))
        {
            Cuenta cta = new CajaDeAhorro(Integer.valueOf(wNumero) ,Double.valueOf(wSaldo));            
            lista.agregar(cta);
            agregarCategorias(cto);
            Archivo.guardar();
            System.out.println("Contacto creado!");
        }
        else
            System.out.println("Error: No se creo el contacto...");
        System.out.println("");

    }

    private void listarMovimientos()
    {
        ListaContactos lista = Archivo.getDatos().getContactos();
        System.out.println("");
        System.out.println(lista);
        System.out.println("");
    }

    private void buscarMovimiento()
    {
        ListaContactos lista = Archivo.getDatos().getContactos();
        System.out.println("");
        System.out.println("Buscar Contacto");
        System.out.print("Nick: ");
        String wNick = In.readLine();
        Contacto cto = lista.buscar(wNick);
        if (cto != null)
            System.out.println(cto);
        else
            System.out.println("No existe!");
        System.out.println("");

    }

    private void filtrarMovimientos()
    {
        ListaContactos lista = Archivo.getDatos().getContactos();
        System.out.println("");
        System.out.println("Filtrar Contactos");
        System.out.print("Filtro: ");
        String wFiltro = In.readLine();
        LinkedList<Contacto> ctos = lista.filtrar(wFiltro);
        if (ctos.size() > 0)
        {
            System.out.println("Contactos para: " + wFiltro);
            for(Contacto item : ctos)
                System.out.println(item);
        }
        else
            System.out.println("Tu filtro no arrojó resultados!");
        System.out.println("");
    }

    private void verCategoria()
    {
        Categoria cat = selectorCategoria();
        if (cat != null)
        {
            System.out.println("Lista de Contactos en la Categoría: " + cat.getNombre());
            for (Contacto item : cat.getContactos())
            {
                System.out.println(item);
            }

            System.out.println("\n\n");

        }

    }

    private char menuCategorias()
    {
        char opc;
        System.out.println("*** Menú Categorias ***");
        System.out.println("1 - Crear Categoria");
        System.out.println("2 - Listar Categorias");
        System.out.println("V - Volver");
        System.out.print("Ingrese Opcion: ");
        opc = Character.toUpperCase(In.readChar());

        return opc;
    }

    private void salida()
    {
        System.out.println("Guardando datos...");
        Archivo.guardar();
        System.out.println("Fin!");
    }

    public Categoria selectorCategoria()
    {
        ListaCategorias lista = Archivo.getDatos().getCategorias();
        Categoria res = null;
        if (lista.getCantidad() > 0)
        {
            System.out.println(lista);
            System.out.println("0 - Cancelar");
            int nro;
            do
            {
                System.out.print("Ingrese el número de categoría: ");
                nro = In.readInt();
                if (nro != 0)
                    res = lista.buscarNro(nro);
            }while (nro != 0 && res == null);
        }
        else
        {
            System.out.println("No hay categorias creadas...");
        }

        return res;

    }

    private void iniciarCategorias()
    {
        char opc;
        do
        {
            opc = menuCategorias();
            switch (opc)
            {
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
        }
        while (opc != 'V');
    }

    private void crearCategoria()
    {
        ListaCategorias lista = Archivo.getDatos().getCategorias();
        System.out.println("");
        System.out.println("Nueva Categoría");
        System.out.print("Nombre: ");
        String nombre = In.readLine();
        if (!nombre.isEmpty())
        {
            int nro = lista.getCantidad() + 1;
            lista.Agregar(new Categoria(nro, nombre));
            Archivo.guardar();
            System.out.println("Categoria creada!");
        }
        else
            System.out.println("Error: No se creo la categoría");
        System.out.println("");
    }

    private void listarCategorias()
    {
        ListaCategorias lista = Archivo.getDatos().getCategorias();
        System.out.println("");
        System.out.println(lista);
        System.out.println("");

    }

    private void agregarCategorias(Contacto cto)
    {
        char rpta;
        ListaCategorias lista = Archivo.getDatos().getCategorias();
        do
        {
            System.out.println("Desea agregar el contacto a una categoría (s/n)");
            rpta = Character.toLowerCase(In.readChar());
            if (rpta == 's')
            {
                Categoria cat = selectorCategoria();
                if (cat != null)
                    cat.agregar(cto);
            }
        }while(rpta != 'n');

    }

    private void importarResumidero()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void exportarResumidero()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void crearMovimiento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
