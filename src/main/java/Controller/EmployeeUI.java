package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeUI  extends JFrame {
    private JButton updateEmployeeButton;
    private JButton deleteEmployeeButton;
    private JButton ADDEmployeeButton;
    public JPanel backPane;

    public EmployeeUI() {
        ADDEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAddEmployee();
            }
        });
        updateEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateEmp();
            }
        });
        deleteEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmp();
            }
        });
    }
    public void viewAddEmployee() {
        AddToEmployee addToEmployeea = new AddToEmployee();
        addToEmployeea.setContentPane(addToEmployeea.backpane);
        addToEmployeea.setTitle("Login CAR-ZONE");
        addToEmployeea.setSize(400,400);
        addToEmployeea.setVisible(true);
    }

    public void UpdateEmp(){

        UpdateEmployee updateEmployee = new UpdateEmployee();
        updateEmployee.setContentPane(updateEmployee.backPane);
        updateEmployee.setTitle("Login CAR-ZONE");
        updateEmployee.setSize(400,400);
        updateEmployee.setVisible(true);
    }

    public void deleteEmp(){

        DeleteEmp deleteEmp = new DeleteEmp();
        deleteEmp.setContentPane(deleteEmp.backPane);
        deleteEmp.setTitle("Login CAR-ZONE");
        deleteEmp.setSize(400,400);
        deleteEmp.setVisible(true);
    }
}
