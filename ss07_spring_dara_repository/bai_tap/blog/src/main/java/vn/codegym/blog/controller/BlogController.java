package vn.codegym.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.service.IBlogService;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping
    public String showBlog(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Blog> blogList = iBlogService.findAll(pageable);
        model.addAttribute("blogList", blogList);
        return "blog";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        iBlogService.save(blog);
        return "redirect:";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "view";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        iBlogService.remove(id);
        return "redirect:";
    }
}
