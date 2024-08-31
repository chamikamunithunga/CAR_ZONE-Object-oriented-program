package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliersDto {

    private String Name;
    private String SUP_id;
    private String Qty;
    private String P_number;
    private int Price;
    private String Address;


}
