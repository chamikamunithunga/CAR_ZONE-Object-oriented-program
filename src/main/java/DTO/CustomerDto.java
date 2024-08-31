package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String Id;
    private String Name;
    private String problem;
    private String orders;
    private int contact;
    private String email;
    private String empId;

}
