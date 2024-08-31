package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


import Model.SuppliresModle;

public class DeleteToSuppliers extends JFrame {
    private JTextField txtSupId;
    private JButton btnDeleteSup;
    public JPanel backPane;
    private JButton cleraButton;
    SuppliresModle suppliresModle = new SuppliresModle();

    public DeleteToSuppliers() {
        btnDeleteSup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sup_Id = txtSupId.getText();
                try {
                    boolean isDeleted = suppliresModle.deleteSuppliers(sup_Id);
                    if(isDeleted) {
                        JOptionPane.showMessageDialog(null, "Suppliers member has been deleted!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Suppliers ID not matched!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cleraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSupId.setText(" ");
            }
        });
    }

    public static void main(String[] args) {

    }
}
