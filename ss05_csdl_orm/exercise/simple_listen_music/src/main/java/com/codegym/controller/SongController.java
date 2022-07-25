package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping
    public String showIndex(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "index";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("song") Song song) {
        songService.save(song);
        return "redirect:/index";
    }

    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }

    @PostMapping("update")
    public String edit(@RequestParam("editId") int id, @RequestParam("editName") String name) {
        Song song = new Song();
        song = songService.findById(id);
        song.setName(name);
        return "redirect:/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        songService.remove(id);
        return "redirect:/index";
    }
}
