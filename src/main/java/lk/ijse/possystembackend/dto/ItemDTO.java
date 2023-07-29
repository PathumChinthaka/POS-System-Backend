package lk.ijse.possystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    private String itemCode;
    private String itemName;
    private String category;
    private String brand;
    private String qty;
    private String unitPrice;
}
