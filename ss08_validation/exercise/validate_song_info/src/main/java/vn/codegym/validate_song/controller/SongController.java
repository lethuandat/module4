package vn.codegym.validate_song.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.validate_song.model.Song;
import vn.codegym.validate_song.dto.SongDto;
import vn.codegym.validate_song.service.ISongService;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;

    @GetMapping("/song")
    public String showList(Model model) {
        List<Song> songList = iSongService.findAll();
        model.addAttribute("songList", songList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        redirectAttributes.addFlashAttribute("message", "Add song successful");
        iSongService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("songDto", iSongService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        redirectAttributes.addFlashAttribute("message", "Update song successful");
        iSongService.save(song);
        return "redirect:/song";
    }
}
