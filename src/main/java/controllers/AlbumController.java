package controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import repository.AlbumsRepository;
import repository.SongRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumsRepository albumsRepo;

    @Autowired
    SongRepository songRepo;

    @GetMapping("/albums")
    public String getAlbumList(Model model) {
        model.addAttribute("Albums" , albumsRepo.findAll());
        return "albums.html";
    }

    @GetMapping("/error")
    public String getError(){
        return "error.html";
    }

    @PostMapping("/postaddalbum")
    public RedirectView  addِUserData(@ModelAttribute Album album , Model model){
        try {
            model.addAttribute("album" , album);
            albumsRepo.save(album);
            return new RedirectView("/albums");
        } catch (Exception exception){
            System.out.println(exception);
            return new RedirectView("/error");
        }
    }

    @GetMapping("/oneAlbum")
    public String getOneAlbum(@RequestParam Integer id , Model model){
        Album albumToRender = albumsRepo.findById(id).get();
        model.addAttribute("album" , albumToRender);
        List<Song> albumSongs = songRepo.findAllByAlbum(albumToRender);
        model.addAttribute("songs" , albumSongs);
        return "oneAlbum.html";
    }
}
