/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;

import Model.InvoiceHeader;
import Model.InvoiceLine;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.IllegalFormatException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static sales.loadFile.frame;

/**
 *
 * @author johny
 */
public class savefile {
        private start frame;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // day - month - year

    public savefile(start frame) {this.frame = frame;}
    
    public void saveFileMenuBar() throws Exception {
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
            if(exist(headerFile.toString())){
                if(accept(headerFile))
                {   
                
            try {
                FileWriter filewriterl = new FileWriter(headerFile);
                
                filewriterl.write(headers);
                filewriterl.flush();
                filewriterl.close();

                JOptionPane.showMessageDialog(frame, "Please, select file to save lines data.", "Lines File", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                      if(exist(linesFile.toString())){
                if(accept(linesFile))
                {   
                    FileWriter filewriterh = new FileWriter(linesFile);
                    filewriterh.write(lines);
                    filewriterh.flush();
                    filewriterh.close();
                }
                  else
           {
               JOptionPane.showMessageDialog(frame, "Error: Wrong File Extension should be .CSV  " , "Error: ", JOptionPane.ERROR_MESSAGE);
               throw new Exception();
           }
           }
           else
           {
                JOptionPane.showMessageDialog(frame, "Error: File Not Found  " , "Error: ", JOptionPane.ERROR_MESSAGE);
               throw new Exception();
           }
                }
                
            }
            catch (FileNotFoundException ex) {
               JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);
            }
             catch (IllegalFormatException el) {
                 JOptionPane.showMessageDialog(frame, "Error: Wrong File Format  " , "Error: ", JOptionPane.ERROR_MESSAGE);
            }
             catch (Exception ex) {JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);}
            }
                
            else
           {
               JOptionPane.showMessageDialog(frame, "Error: Wrong File Extension should be .CSV  " , "Error: ", JOptionPane.ERROR_MESSAGE);
               throw new Exception();
           }
           }
           else
           {
                JOptionPane.showMessageDialog(frame, "Error: File Not Found  " , "Error: ", JOptionPane.ERROR_MESSAGE);
               throw new Exception();
           }
        
    }
    }
    

    public boolean exist (String filePath)
    {
        Path path = Paths.get(filePath);
        boolean exists = Files.isRegularFile(path);
        
        if (exists) {
          return true;
        }
        else {
             return false;

        }
    }
    
    public boolean accept (File file)
    {
        if(file.getName().endsWith(".csv"))
        {
            return true;
        }
        else
        {
            return false;
        }
        
      
    }
}

