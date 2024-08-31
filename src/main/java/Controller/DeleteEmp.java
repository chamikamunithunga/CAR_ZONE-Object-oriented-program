package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Model.EmployeeModle;


public class DeleteEmp extends JFrame {
    public JPanel backPane;
    private JTextField txtEmployeeId;
    private JButton BtnDelete;
    private JButton clearButton;
    EmployeeModle employeeModle = new EmployeeModle();
    public DeleteEmp() {
        BtnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Emp_Id = txtEmployeeId.getText();
                try {
                    boolean isDeleted = employeeModle.deleteEmployee(Emp_Id);
                    if(isDeleted) {
                        JOptionPane.showMessageDialog(null, "customer member has been deleted!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "customer ID not matched!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                    }
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtEmployeeId.setText("");
            }
        });
    }


}
