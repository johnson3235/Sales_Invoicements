/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author johny
 */
public class InvoiceLineJTableModel  extends AbstractTableModel{
      private List<InvoiceLine> invoicesLineList;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // day - month - year

    public InvoiceLineJTableModel(List<InvoiceLine> invoicesLinesList) {this.invoicesLineList = invoicesLinesList;}

    public List<InvoiceLine> getInvoicesLinesList() {return invoicesLineList;}

    public void setInvoicesLinesList(List<InvoiceLine> invoicesLinesList) {this.invoicesLineList = invoicesLinesList;}

    @Override
    public int getRowCount() {return invoicesLineList.size();}

    @Override
    public int getColumnCount() {return 5;}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine row = invoicesLineList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> row.getItemNumber();
            case 1 -> row.getItemName();
            case 2 -> row.getPriceItems();
            case 3 -> row.getCountItems();
            case 4 -> row.getLineTotal();
            default -> "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "NO.";
            case 1 -> "Item Name";
            case 2 -> "Item Price";
            case 3 -> "Count";
            case 4 -> "Item Total";
            default -> "";
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> Integer.class;
            case 1 -> String.class;
            case 2 -> Double.class;
            case 3 -> Integer.class;
            case 4 -> Double.class;
            default -> Object.class;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {return false;}
}
