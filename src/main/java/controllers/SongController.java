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

import java.util.List;

@Controller
public class SongController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumsRepository albumsRepository;


    @GetMapping("/song")
    public String getAllSongs(Model model) {
        model.addAttribute("song" , songRepository.findAll());
        return "song.html";
    }

    @GetMapping("/nosong")
    public String getNoSong(){
        return "noSongs.html";
    }

    @PostMapping("/addsong")
    public RedirectView addSong(@RequestParam String title, Integer length , Integer  trackNumber , Integer id , Model model){
        Album songAlbum = albumsRepository.findById(id).get();
        List<Song> albumSongs = songRepository.findAllByAlbum(songAlbum);
        if (songAlbum.getSongCount() > albumSongs.size()){
            Song addNewSong = new Song(title , length , trackNumber , songAlbum);
            songRepository.save(addNewSong);
            return new RedirectView("/oneAlbum?id="+id) ;
        }else {
         return new RedirectView("/nosong");
        }
    }
}
