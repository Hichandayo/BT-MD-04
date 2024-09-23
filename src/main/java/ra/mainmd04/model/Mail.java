package ra.mainmd04.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mail {
    private int id;
    private String language;
    private int pages;
    private boolean spams;
    private String signature;
}
