package ra.mainmd04.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String address;
    private String phone;
    private boolean status;

    public User(String fullName, String email, String password, String address, String phone, boolean status) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.status = true;
    }
}