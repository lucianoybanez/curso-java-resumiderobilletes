/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.ui.modelos;


import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import utn.resumiderobilletes.entidades.Cuenta;
import utn.resumiderobilletes.utils.DateUtil;

/**
 *
 * @author Luciano Ybañez
 */
public class ModeloCuentas extends AbstractTableModel
{

    private String[] columnas = {"Nº", "Tipo", "Saldo"};
    private List<Cuenta> cuentas;

    public ModeloCuentas()
    {
        cuentas = new LinkedList<Cuenta>();
    }

    public ModeloCuentas(List<Cuenta> lista)
    {
        cuentas = lista;
    }

    @Override
    public int getRowCount()
    {
        int wRes = 10;
        if (cuentas.size() > 10)
        {
            wRes = cuentas.size();
        }
        return wRes;
    }

    @Override
    public int getColumnCount()
    {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        String res = "";
        if (rowIndex < cuentas.size())
        {
            Cuenta aux = cuentas.get(rowIndex);
            switch (columnIndex)
            {
                case 0:
                    res = String.valueOf(aux.getNumeroCuenta());
                    break;
                case 1:
                    res = aux.getTipo();
                    break;
                case 2:
                    res = String.valueOf(aux.getSaldo());
                    break;
            }
        }
        return res;
    }

    @Override
    public String getColumnName(int column)
    {
        return columnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }

    public Cuenta getItem(int pRowIndex)
    {
        Cuenta wResp = null;
        if(pRowIndex < cuentas.size())
            wResp = cuentas.get(pRowIndex);
        return wResp;
    }
    
    
}
