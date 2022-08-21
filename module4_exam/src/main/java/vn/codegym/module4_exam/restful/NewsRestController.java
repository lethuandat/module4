package vn.codegym.module4_exam.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.module4_exam.service.NewsService;

@Configuration
@CrossOrigin
@RequestMapping("/news/api1")
public class NewsRestController {
    @Autowired
    NewsService newsService;

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Integer id) {
        return new ResponseEntity<>(newsService.findById(id), HttpStatus.OK);
    }
}
