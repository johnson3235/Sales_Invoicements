/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author johny
 */
public class InvoiceHeader {


/**
 *
 * @author karim taha
 */

    private int invoiceNumber;
    private Date invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> invoiceLines;

    public InvoiceHeader() {}

    public InvoiceHeader(int invoiceNumber, String customerName, Date invoiceDate) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public  int getInvoiceNumber() {return invoiceNumber;}

    public void setInvoiceNumber(int invoiceNumber) {this.invoiceNumber = invoiceNumber;}

    public Date getInvoiceDate() {return invoiceDate;}

    public void setInvoiceDate(Date invoiceDate) {this.invoiceDate = invoiceDate;}

    public String getCustomerName() {return customerName;}

    public void setCustomerName(String customerName) {this.customerName = customerName;}

    public ArrayList<InvoiceLine> getInvoiceLines() {
        if (invoiceLines == null) {invoiceLines = new ArrayList<>();}
        return invoiceLines;
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {this.invoiceLines = invoiceLines;}

    public double getInvoiceTotal() {
        double total = 0.0;
        for (int i = 0; i < invoiceLines.size(); i++) {total += invoiceLines.get(i).getLineTotal();}
        return total;
    }

    @Override
    public String toString() {
        String myString = "InvoiceHeader{" + "invoiceNumber=" + invoiceNumber + ", customerName=" + customerName + ", invoiceDate= " + invoiceDate + "}";
        for (InvoiceLine line : getInvoiceLines()) {
            myString += "\n\t" + line;
        }
        return myString;
    }

    public void addInvoiceLine(InvoiceLine line) {getInvoiceLines().add(line);}

    public String getDataAsCSV() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getInvoiceNumber() + "," + df.format(getInvoiceDate()) + "," + getCustomerName();
    }

}


