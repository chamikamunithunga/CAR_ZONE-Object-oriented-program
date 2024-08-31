package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerJobDto {
    String orderId;
    String cusId;
    String empID;
    String prblem;
}
