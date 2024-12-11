package Croma21.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long inventoryId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    @Column(name = "price", nullable = false)
    private Float price;

}