package Controller;

import Model.CustomerModle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteCustomer extends JFrame {
    public JPanel backPane;
    private JTextField txtCustomerid;
    private JButton deleteButton;
    private JButton cancelButton;
CustomerModle customerModle = new CustomerModle();
    public DeleteCustomer() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtCustomerid.getText();

                try {
                    boolean isDeleted = customerModle.deleteCustomer(id);
                    if(isDeleted) {
                        JOptionPane.showMessageDialog(null, "customer member has been deleted!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "customer ID not matched!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   txtCustomerid.setText(" ");

            }
        });
    }

}
