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
        ArrayList <Album> tesList=new ArrayList<>();

        Album testAlbum1=new Album("Kifk Enta","Fayrouz",500,400,"https://i.ytimg.com/vi/LL5WYA3TOTQ/hqdefault.jpg");
        Album testAlbum2=new Album("Natali","Hossam Tahseen Beik",500,400,"https://i.ytimg.com/vi/kDPE3H6tQGo/hqdefault.jpg");
        Album testAlbum3=new Album("Qolee Ohibk","Kathem Al-Saher",1000,500,"hhttps://i1.sndcdn.com/avatars-000251131949-55rvs8-t500x500.jpg");
        tesList.add(testAlbum1);
        tesList.add(testAlbum2);
        tesList.add(testAlbum3);


        model.addAttribute("Albums" ,tesList);
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
