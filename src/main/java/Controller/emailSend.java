package Controller;

import DBLayer.DbConnection;
import com.google.protobuf.Message;
import com.mysql.cj.Session;
import com.sun.net.httpserver.Authenticator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.sql.*;
import java.util.Properties;

public class emailSend extends JFrame {
    private JButton sendEmailToCustomerButton;
    private JButton sendEmailToEmployeeButton;
    public JPanel backPane;
    private JTextField txtCustomerID;
    private JTextField txtEmpId;

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;

    //    Go to https://myaccount.google.com/u/7/lesssecureapps and toggle on Allow Less secure apps
    private static final String EMAIL_USERNAME = "car.zone008@gmail.com"; // Replace with your Gmail username
    private static final String EMAIL_PASSWORD = "carZone2024"; // Replace with your Gmail password

    EmailSendCustomer emailSendCustomer = new EmailSendCustomer();

    public emailSend() {


        sendEmailToCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String customer = txtCustomerID.getText();
                    String query = "SELECT * FROM customer WHERE customerID = ?";


                    try (Connection connection = DbConnection.getInstance().getConnection();
                         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                        preparedStatement.setString(1, customer);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        if (resultSet.next()) {
                            String email = resultSet.getString("email");
                            System.out.println(email);
                            emailSendCustomer.sendMail(email);
                            // Perform further actions, e.g., send email or update UI
                        }

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);


                    }

                }catch (RuntimeException exception){
                    System.out.println(exception);
                }
            }
        });
    }



    public static void main(String[] args) {
        emailSend emailSend = new emailSend();
        emailSend.setContentPane(emailSend.backPane);
        emailSend.setTitle("Login CAR-ZONE");
        emailSend.setSize(400,400);
        emailSend.setVisible(true);
    }
}
