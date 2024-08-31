package Model;

import DBLayer.DbConnection;
import DTO.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerModle {
    // functios
    public boolean saveCustomer(CustomerDto customerDto) throws SQLException {
        //db connctiond
        Connection connection = DbConnection.getInstance().getConnection();
        // data insert to database
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, customerDto.getId());
        ptsm.setString(2, customerDto.getName());
        ptsm.setString(3, customerDto.getProblem());
        ptsm.setString(4, customerDto.getOrders());
        ptsm.setInt(5, customerDto.getContact());
        ptsm.setString(6, customerDto.getEmail());
        ptsm.setString(7, customerDto.getEmpId());
        return ptsm.executeUpdate() > 0;
    }

    public boolean updateCustomer(CustomerDto customerDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE customer SET name = ?, problem = ?, orders = ?, contact = ?, email = ?, empID = ? WHERE customerID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, customerDto.getName());
        pstm.setString(2, customerDto.getProblem());
        pstm.setString(3, customerDto.getOrders());
        pstm.setInt(4, customerDto.getContact());
        pstm.setString(5, customerDto.getEmail());
        pstm.setString(6, customerDto.getEmpId());
        pstm.setString(7, customerDto.getId());

        return pstm.executeUpdate() > 0;
    }

    public boolean deleteCustomer(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM customer WHERE customerID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }
}
