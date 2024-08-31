package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerUI extends JFrame {
    public JPanel backPane;
    private JButton updateCustomerButton;
    private JButton deleteCustomerButton;
    private JButton ADDCustomerButton;


    public CustomerUI() {
        ADDCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAddCustomer();
            }
        });

        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {viewDeleteCustomer();}
        });
        updateCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewUpdateCustomer();
            }
        });
    }

    public void viewAddCustomer() {
        AddToCustomer addToCustomer = new AddToCustomer();
        addToCustomer.setContentPane(addToCustomer.backPane);
        addToCustomer.setTitle("Login CAR-ZONE");
        addToCustomer.setSize(400,400);
        addToCustomer.setVisible(true);

    }

    public void viewUpdateCustomer() {
        UpdateCustomer updateCustomer = new UpdateCustomer();
        updateCustomer.setContentPane(updateCustomer.backPane);
        updateCustomer.setTitle("Login CAR-ZONE");
        updateCustomer.setSize(400,400);
        updateCustomer.setVisible(true);

    }

    public void  viewDeleteCustomer(){
        DeleteCustomer deleteCustomer = new DeleteCustomer();
        deleteCustomer.setContentPane(deleteCustomer.backPane);
        deleteCustomer.setSize(400,400);
        deleteCustomer.setVisible(true);
    }
}
