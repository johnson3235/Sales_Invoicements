/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Model.InvoiceHeader;
import Model.InvoiceLine;
import Model.InvoiceLineJTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sales.close;
import sales.loadFile;
import sales.savefile;
import sales.start;

/**
 *
 * @author johny
 */
public class ImplementsListner implements ActionListener, ListSelectionListener {
    private start frame;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // day - month - year
    close menuBarItemsActionListners;
    buttons_action buttonsActionListners;
    loadFile loadFileMenuBarActionListner;
    savefile saveFileMenuBarActionListner;
    close closeFileMenuBarActionListner;
    
    
    public ImplementsListner(start frame) {
        this.frame = frame;
        this.buttonsActionListners = new buttons_action(frame);
        this.loadFileMenuBarActionListner = new loadFile(frame);
        this.saveFileMenuBarActionListner = new savefile(frame);
        this.closeFileMenuBarActionListner = new close(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "LoadFile":
            {
                try {
                    loadFileMenuBarActionListner.loadFileMenuBar();
                    break;
                } catch (Exception ex) {
                    Logger.getLogger(ImplementsListner.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case "SaveFile" : {
                try {
                    saveFileMenuBarActionListner.saveFileMenuBar();
                     break;
                } catch (Exception ex) {
                    Logger.getLogger(ImplementsListner.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case "CloseFile" : closeFileMenuBarActionListner.closeFileMenuBar(); break;
            case "CreateNewInvoiceButton" : buttonsActionListners.displayNewInvoiceDialog(); break;
            case "DeleteInvoiceButton" : buttonsActionListners.deleteInvoiceButton(); break;
            case "SaveButton" : buttonsActionListners.displaySaveButtonNewLineDialog(); break;
            case "CancelButton" : buttonsActionListners.cancelButton(); break;
            case "InsertButtonInDialog" : buttonsActionListners.insertButtonInDialog(); break;
            case "CancelButtonInDialog": buttonsActionListners.cancelButtonInDialog(); break;
            case "createLineOK" : buttonsActionListners.okButtonNewLineInDialog(); break;
            case "createLineCancel" : buttonsActionListners.cancelButtonNewLineInDialog(); break;
            default : throw new AssertionError();
        }
    }

    private void rowSelected_InvoiceTable() {
        
        int selectedRowIndex_InvoiceTable = frame.getInvoiceTableJTableLeftSide().getSelectedRow();
        
        if (selectedRowIndex_InvoiceTable >= 0) { // row >= 0 cause don't work with negative
            
            // effect on data in the top right side 
            InvoiceHeader row = frame.getInvoiceHeaderJTableModel().getInvoicesHeaderList().get(selectedRowIndex_InvoiceTable);
            frame.getCustomerNameJTextField().setText(row.getCustomerName());
            frame.getInvoiceDateJTextField().setText(dateFormat.format(row.getInvoiceDate()));
            frame.getInvoiceNumberJLabel().setText("" + row.getInvoiceNumber());
            frame.getInvoiceTotalJLabel().setText("" + row.getInvoiceTotal());
            ArrayList<InvoiceLine> lines = row.getInvoiceLines();

            // line table model
            frame.setInvoiceLineJTableModel(new InvoiceLineJTableModel(lines));
            frame.getInvoiceItemJTableRightSide().setModel(frame.getInvoiceLineJTableModel());
            frame.getInvoiceLineJTableModel().fireTableDataChanged();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        rowSelected_InvoiceTable();
    }
}
