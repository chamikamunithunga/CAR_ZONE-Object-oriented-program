package Controller;

import DTO.CustomerDto;
import Model.CustomerModle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddToCustomer extends JFrame {
    private JTextField txtName;
    private JTextField txtCustomerID;
    private JTextField txtproblem;
    private JTextField txtOrders;
    private JTextField txtContact;
    private JTextField txtEmail;
    private JButton BtnCSave;
    private JButton btnClearFeilds;
    public JPanel backPane;
    private JTextField txtempID;
    private JLabel email;
    private JTable CustomersTable;
    //creat csutomer model object for acses it functions
    CustomerModle customerModle = new CustomerModle();

    public AddToCustomer() {
        //model = SQL conctions
        //DTO = data tranfer object

        BtnCSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id =txtCustomerID.getText();
                String name = txtName.getText();
                String problem = txtproblem.getText();
                String Orders = txtOrders.getText();
                int contact = Integer.parseInt(txtContact.getText());
                String email = txtEmail.getText();
                String empId = txtempID.getText();
                   // txt filed value into the DTO object for data transfer-
                    var customerDto = new CustomerDto(id,name,problem,Orders,contact,email,empId);
                try{
                    boolean isSave = customerModle.saveCustomer(customerDto);
                    if (isSave){
                        JOptionPane.showMessageDialog(null, "Staff member has been saved!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (SQLException exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnClearFeilds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtName.setText("");
                txtContact.setText("");
                txtCustomerID.setText("");
                txtproblem.setText("");
                txtOrders.setText("");
                txtempID.setText("");
            }
        });
    }


}
