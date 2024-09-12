package ra.mainmd04.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    private int id;
    private String name;
    private String password;
    private String fullName;
    private int balance;
}
