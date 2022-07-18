/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author johny
 */
public class InvoiceLine {
      private int itemNumber;
    private String itemName;
    private double priceItems;
    private int countItems;
    private InvoiceHeader invoiceHeader;

    public InvoiceLine() {}

    public InvoiceLine(int itemNumber, String itemName, double priceItems, int countItems, InvoiceHeader invoiceHeader) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.priceItems = priceItems;
        this.countItems = countItems;
        this.invoiceHeader = invoiceHeader;
    }

    public int getItemNumber() {return itemNumber;}

    public void setItemNumber(int itemNumber) {this.itemNumber = itemNumber;}

    public InvoiceHeader getInvoiceHeader() {return invoiceHeader;}

    public void setInvoiceHeader(InvoiceHeader invoiceHeader) {this.invoiceHeader = invoiceHeader;}

    public String getItemName() {return itemName;}

    public void setItemName(String itemName) {this.itemName = itemName;}

    public double getPriceItems() {return priceItems;}

    public void setPriceItems(double priceItems) {this.priceItems = priceItems;}

    public int getCountItems() {return countItems;}

    public void setCountItems(int countItems) {this.countItems = countItems;}

    public double getLineTotal() {return priceItems * countItems;}

    public String getDataAsCSV() {return "" + getInvoiceHeader().getInvoiceNumber() + "," + getItemName() + "," + getPriceItems() + "," + getCountItems();}
}
