package ra.mainmd04.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int category_id;
    private boolean status;
}
