package ra.mainmd04.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medical {
    private int id;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String healthIssues;
}