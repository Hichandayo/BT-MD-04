package ra.mini.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Book {
    private int id;
    private int categoryId;
    private String name;
    private double price;
    private int stock;
    private int totalPages;
    private int yearCreated;
    private String author;
    private boolean status;

}
