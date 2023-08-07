package lk.ijse.possystembackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Customer implements SuperEntity {
    @Id
    private String cusId;
    private String cusName;
    private String address;
    private int nic;
    private String email;
    private int contact;


//    @OneToMany(targetEntity = Order.class,mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @ToString.Exclude
//    private List<Order>orderList=new ArrayList<>();
}
