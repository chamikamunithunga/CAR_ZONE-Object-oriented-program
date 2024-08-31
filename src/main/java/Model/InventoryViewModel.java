package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import DBLayer.DbConnection;
import DTO.InventoryViewDto;

public class InventoryViewModel {
   public List<InventoryViewDto> getAllInventroy() throws SQLException {

       Connection connection = DbConnection.getInstance().getConnection();
       String SQl = "SELECT * FROM supplier ";
       PreparedStatement pstm = connection.prepareStatement(SQl);
       ResultSet resultSet = pstm.executeQuery();

       ArrayList<InventoryViewDto> inventoryDtoArrayList = new ArrayList<>();

       while (resultSet.next()){
           inventoryDtoArrayList.add(
                   new InventoryViewDto(
                   resultSet.getString(1),
                   resultSet.getString(2),
                   resultSet.getString(3),
                   resultSet.getInt(4)
                   )
           );
       }
       return inventoryDtoArrayList;
   }
}
