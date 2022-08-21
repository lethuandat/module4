package vn.codegym.module4_exam.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.module4_exam.dto.NewsDto;
import vn.codegym.module4_exam.model.Category;
import vn.codegym.module4_exam.model.News;
import vn.codegym.module4_exam.service.CategoryService;
import vn.codegym.module4_exam.service.NewsService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    NewsService newsService;


    @GetMapping
    public String showPage(@PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> keyword, Model model) {
        model.addAttribute("keyword", keyword.orElse(""));
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("newsList", newsService.findAll(pageable, keyword.orElse("")));
        return "list";
    }


    @GetMapping("/search")
    public String search(@PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> keyword, Model model) {
        model.addAttribute("keyword", keyword.orElse(""));
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("newsList", newsService.findAll(pageable, keyword.orElse("")));
        return "list";
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("newsDto", new NewsDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("newsDto") NewsDto newsDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (!newsDto.getDate().equals("")) {
            new NewsDto().validate(newsDto, bindingResult);
        }

        if (bindingResult.hasFieldErrors()) {
            List<Category> categoryList = categoryService.findAll();
            model.addAttribute("categoryList", categoryList);
            return "create";
        }

        News news = new News();
        BeanUtils.copyProperties(newsDto, news);

        news.setDate(LocalDate.parse(newsDto.getDate()));
        news.setCategory(new Category(Integer.parseInt(newsDto.getCategory())));

        newsService.save(news);

        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/news";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        newsService.remove(id);
        return "redirect:/news";
    }
}
