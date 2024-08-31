package Model;

import DBLayer.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModle {
    public boolean isValidUser(String userName, String pw) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM user WHERE userName = ? AND password = ?";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, userName);
        ptsm.setString(2, pw);

        ResultSet resultSet = ptsm.executeQuery();

        return resultSet.next();
    }
}
