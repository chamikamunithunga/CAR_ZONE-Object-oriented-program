package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import DTO.SuppliersDto;
import Model.SuppliresModle;

public class UpdareToSuppliers extends JFrame {

    private JTextField txtSupId;
    private JTextField txtSupName;
    private JTextField txtSupAddress;
    private JTextField txtsupPnumber;
    private JTextField txtQty;
    private JTextField textPrice;
    private JButton updateButton;
    public JPanel backPane;
    private JButton cleraButton;
   SuppliresModle suppliresModle = new SuppliresModle();
    public UpdareToSuppliers() {
        cleraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSupId.setText("");
                txtSupName.setText("");
                txtSupAddress.setText("");
                txtSupName.setText("");
                txtQty.setText("");
                textPrice.setText("");


            }

        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String S_name = txtSupName.getText();
                String S_ID = txtSupId.getText();
                String P_number  = txtSupName.getText();
                String qty = txtQty.getText();
                int price=Integer.parseInt(textPrice.getText());
                String adrees = txtSupAddress.getText();

                var SuppliersDto = new SuppliersDto(S_name,S_ID,qty,P_number,price,adrees);

                try{
                    boolean isSave = suppliresModle.updatesupplires(SuppliersDto);
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
