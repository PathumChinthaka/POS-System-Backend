package lk.ijse.possystembackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Order {
    @Id
    private String orderId;
    private String itemCode;
    private String itemName;
    private double price;
    private int itemQty;
    private double total;
}
