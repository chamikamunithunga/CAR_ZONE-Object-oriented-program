package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import DTO.CustomerJobDto;
import DTO.OrderDto;
import Model.CustomerJobModel;

public class CustomerJobs extends JFrame {

    public JPanel backPane;
    private JTable CustomerJobsTable;
    private JTextField EmpID;
    private JButton markFinshButton;
    private JTextField txtorderId;
    private JTextField txtCustomerId;
    private JTextField txtEmpId;
    private JTextField txtProblm;
    private JButton saveButton;
    private JButton clearButton;
    private JTextField textCname;
    private JTextField textPrice;
    CustomerJobModel customerJobModel = new CustomerJobModel();
    private DefaultTableModel tableModel;

    public CustomerJobs() {
        markFinshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   String orderId = EmpID.getText();
                   String price = textPrice.getText();
                   String cname = textCname.getText();
                   var OrderDto = new OrderDto(orderId,cname,price);

;                try {
                    boolean isDeleted = customerJobModel.deleteCustomerOrder(orderId);
                    customerJobModel.saveCustomerFishOrder(OrderDto);
                    if(isDeleted) {
                        JOptionPane.showMessageDialog(null, "Fishid the order place send Email to customer", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Suppliers ID not matched!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oid = txtorderId.getText();
                String CustomerId = txtCustomerId.getText();
                String problm = txtProblm.getText();
                String EmpId = txtEmpId.getText();

                var CustomerJobDyo = new CustomerJobDto(oid,CustomerId,problm,EmpId);
                try{
                    boolean isSave = customerJobModel.saveCustomerJob(CustomerJobDyo);
                    if (isSave){
                        JOptionPane.showMessageDialog(null, "Customer job member has been saved!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (SQLException exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtorderId.setText("");
                txtCustomerId.setText("");
                txtProblm.setText("");
                txtEmpId.setText("");
            }
        });
    }

    public  void cretaTableUI(){
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Customer Id");
        tableModel.addColumn("Emp Id");
        tableModel.addColumn("Job type");
        CustomerJobsTable = new JTable(tableModel);

    }


}
