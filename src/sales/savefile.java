/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;

import Model.InvoiceHeader;
import Model.InvoiceLine;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author johny
 */
public class savefile {
        private start frame;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // day - month - year

    public savefile(start frame) {this.frame = frame;}
    
    public void saveFileMenuBar() {
        String headers = "";
        String lines = "";
        for (InvoiceHeader header : frame.getInvoicesHeaderList()) {
            headers += header.getDataAsCSV();
            headers += "\n";
            for (InvoiceLine line : header.getInvoiceLines()) {
                lines += line.getDataAsCSV();
                lines += "\n";
            }
        }

        JOptionPane.showMessageDialog(frame, "Please, select file to save header data.", "Header File", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fileChooser.getSelectedFile();
            try {
                FileWriter filewriterl = new FileWriter(headerFile);
                filewriterl.write(headers);
                filewriterl.flush();
                filewriterl.close();

                JOptionPane.showMessageDialog(frame, "Please, select file to save lines data.", "Lines File", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                    FileWriter filewriterh = new FileWriter(linesFile);
                    filewriterh.write(lines);
                    filewriterh.flush();
                    filewriterh.close();
                }
            } catch (Exception ex) {JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);}
        }
        JOptionPane.showMessageDialog(frame, "Data saved successfully", "Saved", JOptionPane.INFORMATION_MESSAGE);
    }
}
