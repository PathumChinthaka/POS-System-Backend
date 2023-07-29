package lk.ijse.possystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {
    private String orderId;
    private String itemCode;
    private String itemName;
    private double price;
    private int itemQty;
    private double total;
}
