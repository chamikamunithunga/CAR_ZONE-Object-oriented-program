package Controller;

import DBLayer.DbConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryView extends JFrame {
    public JPanel backPane;
    private JTable InTable;
    private JScrollPane Inven;
    private JButton viewInButton;

    private  DefaultTableModel tableModel;


    public InventoryView() {

        setLayout(new BorderLayout());
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Supplier Name", "Phone number", "Qty", "Price", "Address"});
        InTable = new javax.swing.JTable();
        InTable = new JTable(tableModel);
        Inven = new javax.swing.JScrollPane();
        Inven.setViewportView(InTable);



        refreshTable();

        viewInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                refreshTable();
            }
        });
    }
    private  void refreshTable() {
        try {
            System.out.println("********.refreshTable().*******");
            Connection connection = DbConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM supplier ";
            PreparedStatement pstm = connection.prepareStatement(SQL);
            ResultSet resultSet = pstm.executeQuery();


            // Clear the table model
            tableModel.setRowCount(0);

            while (resultSet.next()) {
                String order_id = resultSet.getString("supplierID");
                String customer_name = resultSet.getString("S_name");
                String email = resultSet.getString("P_number");
                String status = resultSet.getString("qty");
                String empNo = Integer.toString(resultSet.getInt("price"));
                String date = resultSet.getString("address");

                System.out.println("***customer_name***** "+customer_name);
                System.out.println(order_id);
                System.out.println(email);
                System.out.println(status);
                System.out.println(empNo);
                System.out.println(date);
                DefaultTableModel df1 = (DefaultTableModel) InTable.getModel();
                df1.setRowCount(0);
                df1.addRow(new Object[]{order_id, customer_name, email, status, empNo, date});
                System.out.println("count "+tableModel.getRowCount());
            }


        } catch (SQLException ex) {
            // Handle the exception in a user-friendly way
            JOptionPane.showMessageDialog(this, "Error retrieving data from the database.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }







}
