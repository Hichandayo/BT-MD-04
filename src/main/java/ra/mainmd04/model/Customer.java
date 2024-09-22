package ra.mainmd04.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private int id;
    private String name;
    private LocalDate birthDay;
    private String address;
    private String imageUrl;

}
