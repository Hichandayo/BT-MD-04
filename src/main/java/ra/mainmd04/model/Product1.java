package ra.mainmd04.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product1 {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int categoryId;
    private boolean status;
}
