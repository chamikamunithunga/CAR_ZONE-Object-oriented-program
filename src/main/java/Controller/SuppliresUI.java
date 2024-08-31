package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuppliresUI extends JFrame {
    public JPanel backPane;
    private JButton suppliersADDButton;
    private JButton suppliersDeleteButton;
    private JButton suppliersUpdateButton;

    public SuppliresUI() {
        suppliersADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddToSuppliers addToSuppliers = new AddToSuppliers();
                addToSuppliers.setContentPane(addToSuppliers.backPane);
                addToSuppliers.setTitle("Login CAR-ZONE");
                addToSuppliers.setSize(400,400);
                addToSuppliers.setVisible(true);
            }
        });
        suppliersDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteToSuppliers deleteToSuppliers = new DeleteToSuppliers();
                deleteToSuppliers.setContentPane(deleteToSuppliers.backPane);
                deleteToSuppliers.setTitle("Login CAR-ZONE");
                deleteToSuppliers.setSize(400,400);
                deleteToSuppliers.setVisible(true);
            }
        });
        suppliersUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdareToSuppliers updareToSuppliers = new UpdareToSuppliers();
                updareToSuppliers.setContentPane(updareToSuppliers.backPane);
                updareToSuppliers.setTitle("Login CAR-ZONE");
                updareToSuppliers.setSize(400,400);
                updareToSuppliers.setVisible(true);
            }
        });
    }


}
