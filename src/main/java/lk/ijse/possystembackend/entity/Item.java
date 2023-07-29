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
public class Item {
     @Id
     private String itemCode;
     private String itemName;
     private String category;
     private String brand;
     private String qty;
     private String unitPrice;
}
