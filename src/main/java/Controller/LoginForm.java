package Controller;

import Model.UserModle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginForm extends JFrame{


    private JTextField userName;
    private JPasswordField txtPassword;
    private JButton BtnLogin;
    private JPanel backPane;

    UserModle userModle = new UserModle();
    public LoginForm() {
        BtnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userNameText = userName.getText();
               String pw = (txtPassword.getText());

                try {
                    boolean isValid = userModle.isValidUser(userNameText, pw);
                    if (isValid) {
                        viewDasboard();
                    } else {


                        JOptionPane.showMessageDialog(null, "User Name And Password Did Not Matched. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                viewDasboard();

            }
        });
    }

    public void viewDasboard(){
        Dashboard dashboard = new Dashboard();
        dashboard.setContentPane(dashboard.dashboardPane);
        dashboard.setTitle("Login CAR-ZONE");
        dashboard.setSize(400,400);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.initializeComponents();
        setVisible(false);
        dashboard.setVisible(true);
    }

    public static void main(String[]args){

        LoginForm loginForm = new LoginForm();
        loginForm.setContentPane(loginForm.backPane);
        loginForm.setTitle("Login CAR-ZONE");
        loginForm.setSize(700,600);
        loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginForm.setVisible(true);

    }
}


