package Controller;

import DTO.CustomerDto;
import Model.CustomerModle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateCustomer extends  JFrame{
    public JPanel backPane;
    private JTextField txtCustomerId;
    private JTextField txtCustomerNAme;
    private JTextField txtcusProblem;
    private JTextField txtcusOrder;
    private JTextField txtcusContact;
    private JTextField txtCusEmail;
    private JTextArea txtCusEmpId;
    private JButton updateButton;
    private JButton canselButton;
CustomerModle customerModle = new CustomerModle();

    public UpdateCustomer() {
        canselButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCustomerId.setText("");
                txtCustomerNAme.setText("");
                txtcusProblem.setText("");
                txtcusOrder.setText("");
                txtCusEmail.setText("");
                txtCusEmpId.setText("");
                txtcusContact.setText("");


            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id =txtCustomerId.getText();
                String name = txtCustomerNAme.getText();
                String problem = txtcusProblem.getText();
                String Orders = txtcusOrder.getText();
                int contact = Integer.parseInt(txtcusContact.getText());
                String email = txtCusEmail.getText();
                String empId = txtCusEmpId.getText();

                var customerDto = new CustomerDto(id,name,problem,Orders,contact,email,empId);
                try{
                    boolean isSave = customerModle.updateCustomer(customerDto);
                    if (isSave){
                        JOptionPane.showMessageDialog(null, "Staff member has been updated!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (SQLException exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
