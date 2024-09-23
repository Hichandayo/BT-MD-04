package ra.mainmd04.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    private int id;
    private String name;
    private String singer;
    private String genre;
    private String source;
    private MultipartFile single;
    private List<MultipartFile> multiple;

}
