package vn.codegym.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.blog.model.Category;
import vn.codegym.blog.service.ICategoryService;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping
    public String showCategory(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "category";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category) {
        iCategoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "updateCategory";
    }

    @PostMapping("/update")
    public String update(Category category) {
        iCategoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        iCategoryService.remove(id);
        return "redirect:/category";
    }
}
