package ra.mainmd04.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String fullName;
    private String email;
    private String address;
    private String phone;
    private boolean status;

    public Student(String fullName, String email, String address, String phone, boolean status) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

}