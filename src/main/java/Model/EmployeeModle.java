package Model;

import DBLayer.DbConnection;
import DTO.CustomerDto;
import DTO.EmployeesDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeModle {
    public boolean saveEmployee(EmployeesDto employeesDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO employee VALUES (?,?,?,?)";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, employeesDto.getEid());
        ptsm.setString(2, employeesDto.getName());
        ptsm.setString(3, employeesDto.getDuty());
        ptsm.setString(4, employeesDto.getEmail());
        return ptsm.executeUpdate() > 0;
    }

    public  boolean updateEmployee(EmployeesDto employeesDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE  employee SET  name = ?, duty = ?, email = ? WHERE employeeID = ?";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, employeesDto.getName());
        ptsm.setString(2, employeesDto.getDuty());
        ptsm.setString(3, employeesDto.getEmail());
        ptsm.setString(4, employeesDto.getEid());

        return ptsm.executeUpdate() > 0;
    }

    public boolean deleteEmployee(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM employee WHERE employeeID = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }


}
