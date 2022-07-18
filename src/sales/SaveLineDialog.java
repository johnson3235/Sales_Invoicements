/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author johny
 */
public class SaveLineDialog extends JDialog{
     private JLabel itemNameJLabel;
    private JTextField itemNameJTextField;

    private JLabel itemCountJLabel;
    private JTextField itemCountJTextField;

    private JLabel itemPriceJLabel;
    private JTextField itemPriceJTextField;

    private JButton okJButton;
    private JButton cancelJButton;

    public SaveLineDialog(start frame) {
        
        setTitle("Create New Line");
        setLocation(300, 300);

        itemNameJTextField = new JTextField(20);
        itemNameJLabel = new JLabel("Item Name");

        itemCountJTextField = new JTextField(20);
        itemCountJLabel = new JLabel("Item Count");

        itemPriceJTextField = new JTextField(20);
        itemPriceJLabel = new JLabel("Item Price");

        okJButton = new JButton("OK");
        okJButton.setActionCommand("createLineOK");
        okJButton.addActionListener(frame.getListner());

        cancelJButton = new JButton("Cancel");
        cancelJButton.setActionCommand("createLineCancel");
        cancelJButton.addActionListener(frame.getListner());

        setLayout(new GridLayout(4, 2));

        add(itemNameJLabel);
        add(itemNameJTextField);
        add(itemCountJLabel);
        add(itemCountJTextField);
        add(itemPriceJLabel);
        add(itemPriceJTextField);
        add(okJButton);
        add(cancelJButton);

        pack();
    }

    public JTextField getItemNameJTextField() {return itemNameJTextField;}

    public JTextField getItemCountJTextField() {return itemCountJTextField;}

    public JTextField getItemPriceJTextField() {return itemPriceJTextField;}
}
