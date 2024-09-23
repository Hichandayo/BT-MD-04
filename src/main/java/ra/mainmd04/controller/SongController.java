package ra.mainmd04.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import ra.mainmd04.model.Song;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ServletContext servletContext;

    private List<Song> songList = new ArrayList<>();

    @GetMapping
    public String listSongs(Model model) {
        model.addAttribute("songs", songList);
        return "songs";
    }

    @GetMapping("/upload")
    public String addSong(Model model) {
        model.addAttribute("uploadModel", new Song());
        return "upload-song";
    }

    @PostMapping("/upload")
    public String handleUpload(@ModelAttribute("uploadModel") Song song) {
        String path = servletContext.getRealPath("/uploads");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        song.setId(generateNextId());
        String fileUrl = uploadFile(song.getSingle(), path);
        song.setSource(fileUrl);
        songList.add(song);
        return "redirect:/songs";
    }

    private int generateNextId() {
        if (songList.isEmpty()) {
            return 1;
        }
        return songList.get(songList.size() - 1).getId() + 1;
    }

    private String uploadFile(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(path + File.separator + fileName));
            return "/uploads/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}