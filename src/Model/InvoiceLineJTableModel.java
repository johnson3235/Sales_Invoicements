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
         switch (columnIndex) {
            case 0 :  return(row.getItemNumber()); 
            case 1 : return( row.getItemName()); 
            case 2 : return(row.getPriceItems()); 
            case 3 : return(row.getCountItems()); 
            case 4 : return(row.getLineTotal()); 
            default : return("");
        }
    }

    @Override
    public String getColumnName(int column) {
         switch (column) {
            case 0 : return( "NO.");
            case 1 : return("Item Name");
            case 2  : return("Item Price");
            case 3  : return("Count");
            case 4  : return("Item Total");
            default  : return("");
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
         switch (columnIndex) {
            case 0 : return(Integer.class);
            case 1 : return(String.class);
            case 2 :return( Double.class);
            case 3 :return( Integer.class);
            case 4 :return( Double.class);
            default :return( Object.class);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {return false;}
}
