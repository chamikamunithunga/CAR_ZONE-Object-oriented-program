package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import DTO.SuppliersDto;
import Model.SuppliresModle;

public class AddToSuppliers extends JFrame {
    private JTextField txtName;
    private JTextField txtSupId;
    private JTextField txtPnumber;
    private JTextField txtQty;
    private JTextField txtPrice;
    private JButton btnAddSupplires;
    private JTextField txtAddress;
    public JPanel backPane;
    private JButton cleraButton;
    SuppliresModle suppliresModle = new SuppliresModle();

    public AddToSuppliers() {
        btnAddSupplires.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String S_name = txtName.getText();
                String S_ID = txtSupId.getText();
                String P_number  = txtPnumber.getText();
                String qty = txtQty.getText();
                int price=Integer.parseInt(txtPrice.getText());
                String adrees = txtAddress.getText();

                var SuppliersDto = new SuppliersDto(S_name,S_ID,qty,P_number,price,adrees);
                try{
                    boolean isSave = suppliresModle.saveSupplires(SuppliersDto);
                    if (isSave){
                        JOptionPane.showMessageDialog(null, "supplires member has been saved!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (SQLException exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cleraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtName.setText("");
                txtSupId.setText("");
                txtPnumber.setText("");
                txtQty.setText("");
                txtPrice.setText("");
                txtAddress.setText("");

            }
        });
    }
}
