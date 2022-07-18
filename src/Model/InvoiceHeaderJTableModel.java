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
public class InvoiceHeaderJTableModel  extends AbstractTableModel {
     public static int ItemNumberInt;
    private List<InvoiceHeader> invoicesHeaderList;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // day - month - year

    public InvoiceHeaderJTableModel(List<InvoiceHeader> invoicesHeaderList) {this.invoicesHeaderList = invoicesHeaderList;}

    public List<InvoiceHeader> getInvoicesHeaderList() {return invoicesHeaderList;}

    public void setInvoicesHeaderList(List<InvoiceHeader> invoicesHeaderList) {this.invoicesHeaderList = invoicesHeaderList;}

    @Override
    public int getRowCount() {return invoicesHeaderList.size();}

    @Override
    public int getColumnCount() {return 4;}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader row = invoicesHeaderList.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                ItemNumberInt = row.getInvoiceNumber();
                return row.getInvoiceNumber();
            }
            case 1 -> {return dateFormat.format(row.getInvoiceDate());}
            case 2 -> {return row.getCustomerName();}
            case 3 -> {return row.getInvoiceTotal();}
            default -> {return "";}
        }
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "NO.";
            case 1 -> "Date";
            case 2 -> "Customer";
            case 3 -> "Total";
            default -> "";
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> Integer.class;
            case 1 -> String.class;
            case 2 -> String.class;
            case 3 -> Double.class;
            default -> Object.class;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {return false;}
}
