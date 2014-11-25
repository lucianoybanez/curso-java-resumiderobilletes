/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.resumiderobilletes.ui.modelos;


import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import utn.resumiderobilletes.entidades.Movimiento;
import utn.resumiderobilletes.utils.DateUtil;

/**
 *
 * @author Luciano Ybañez
 */
public class ModeloMovimientos extends AbstractTableModel
{

    private String[] columnas = {"Nº", "Fecha", "Monto", "Operación" , "N° Cuenta"};
    private List<Movimiento> movimientos;

    public ModeloMovimientos()
    {
        movimientos = new LinkedList<Movimiento>();
    }

    public ModeloMovimientos(List<Movimiento> lista)
    {
        movimientos = lista;
    }

    @Override
    public int getRowCount()
    {
        int wRes = 25;
        if (movimientos.size() > 25)
        {
            wRes = movimientos.size();
        }
        return wRes;
    }

    @Override
    public int getColumnCount()
    {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        String res = "";
        if (rowIndex < movimientos.size())
        {
            Movimiento aux = movimientos.get(rowIndex);
            switch (columnIndex)
            {
                case 0:
                    res = String.valueOf(aux.getNumero());
                    break;
                case 1:
                    res = DateUtil.toStringDate(aux.getFechaMovimiento());
                    break;
                case 2:
                    res = String.valueOf(aux.getMonto());
                    break;
                case 3:
                    res = aux.isDeposito() ? "Deposito" : "Extracción";
                    break;
                case 4:
                    res = String.valueOf(aux.getCuenta());
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

    public Movimiento getItem(int pRowIndex)
    {
        Movimiento wResp = null;
        if(pRowIndex < movimientos.size())
            wResp = movimientos.get(pRowIndex);
        return wResp;
    }
    
    
}
