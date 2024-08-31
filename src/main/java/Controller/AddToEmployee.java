package Controller;

import DTO.EmployeesDto;
import Model.EmployeeModle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddToEmployee extends JFrame{
    private JButton btnsave;
    private JButton btncancel;
    private JTextField txtEmpD;
    private JTextField txtname;
    private JTextField txtduty;


    public JPanel backpane;
    private JButton cancelButton;
    private JButton saveButton;

    private JLabel lblemail;
    private JTextField txtemail;

    EmployeeModle employeeModle = new EmployeeModle();

    public AddToEmployee() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                      txtEmpD.setText(" ");
                      txtname.setText(" ");
                      txtduty.setText(" ");
                      txtemail.setText(" ");
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id =txtEmpD.getText();
                String name = txtname.getText();
                String duty = txtduty.getText();
                String email = txtemail.getText();

                var employeesDto = new EmployeesDto(id,name,duty,email);
                try{
                    boolean isSave = employeeModle.saveEmployee(employeesDto);
                    if (isSave){
                        JOptionPane.showMessageDialog(null, "Staff member has been saved!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (SQLException exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


}
