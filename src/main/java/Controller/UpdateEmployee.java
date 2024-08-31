package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import DTO.EmployeesDto;
import Model.EmployeeModle;

public class UpdateEmployee extends  JFrame {
    private JTextField txtEOID;
    private JTextField txtEname;
    private JTextField txtEduty;
    private JButton updateButton;
    private JButton cancelButton;
    public JPanel backPane;
    private JTextField txtEmail;

    EmployeeModle employeeModle = new EmployeeModle();
    public UpdateEmployee() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eid = txtEduty.getText();
                String ename = txtEname.getText();
                String E_email = txtEmail.getText();
                String Duty = txtEduty.getText();

                var EmployeesDto = new EmployeesDto(eid,ename,Duty,E_email);
                try{
                    boolean isSave = employeeModle.updateEmployee(EmployeesDto);
                    if (isSave){
                        JOptionPane.showMessageDialog(null, "Employers member has been updated!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (SQLException exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtEOID.setText(" ");
                txtEname.setText(" ");
                txtEduty.setText(" ");
                txtEmail.setText(" ");
            }
        });
    }
}
