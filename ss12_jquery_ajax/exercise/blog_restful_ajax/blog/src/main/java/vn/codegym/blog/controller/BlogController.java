package vn.codegym.blog.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.blog.dto.BlogDto;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.service.IBlogService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/blogs/api/v1")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = iBlogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> viewDetailBlog(@PathVariable Integer id) {
        Optional<Blog> blog = iBlogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Blog>> getBlogWithCategory(@PathVariable Integer id) {
        List<Blog> blogWithCategoryList = iBlogService.findAllByCategoryId(id);
        if (blogWithCategoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogWithCategoryList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> getBlogName(@RequestParam String keyword) {
        List<Blog> blogList = iBlogService.find(keyword);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addBlog(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        iBlogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Integer id, @RequestBody BlogDto blogDto) {
        Optional<Blog> currentBlog = iBlogService.findById(id);
        if (!currentBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentBlog.get().setName(blogDto.getName());

        currentBlog.get().setCategory(blogDto.getCategory());

        currentBlog.get().setContent(blogDto.getContent());

        currentBlog.get().setStatus(blogDto.getStatus());

        iBlogService.save(currentBlog.get());

        return new ResponseEntity(currentBlog.get(), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Integer id) {
        Optional<Blog> blog = iBlogService.findById(id);

        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        iBlogService.remove(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
