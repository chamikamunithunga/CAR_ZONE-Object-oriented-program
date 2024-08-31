package Model;

import DBLayer.DbConnection;
import DTO.CustomerDto;
import DTO.CustomerJobDto;
import DTO.OrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerJobModel {
    public boolean saveCustomerJob(CustomerJobDto customerJobDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO orders VALUES (?,?,?,?)";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, customerJobDto.getOrderId());
        ptsm.setString(2,customerJobDto.getCusId());
        ptsm.setString(3, customerJobDto.getEmpID());
        ptsm.setString(4, customerJobDto.getPrblem());

        return ptsm.executeUpdate() > 0;
    }

    public boolean deleteCustomerOrder(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM orders WHERE orderID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

    public boolean saveCustomerFishOrder(OrderDto orderDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO Repoart VALUES (?,?,?)";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, orderDto.getOrderID());
        ptsm.setString(2, orderDto.getCustName());
        ptsm.setString(3, orderDto.getPrice());


        return ptsm.executeUpdate() > 0;
    }
}
