package vn.codegym.lend_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.lend_book.model.Book;
import vn.codegym.lend_book.model.UserLendBook;
import vn.codegym.lend_book.service.BookService;
import vn.codegym.lend_book.service.UserLendBookService;

import java.util.List;

@Controller
@RequestMapping("book")
public class LendBookController {
    @Autowired
    UserLendBookService userLendBookService;

    @Autowired
    BookService bookService;

    @GetMapping
    public String showPage(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "view";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        model.addAttribute("userLend", new UserLendBook());
        return "lend";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("userLend") UserLendBook userLendBook, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(userLendBook.getBook().getId());
        if (book.getQuantity() == 0) {
            redirectAttributes.addFlashAttribute("message", "Mượn thất bại, sách đã hết, bạn quay lại sau!");
        } else {
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);

            userLendBookService.save(userLendBook);
            redirectAttributes.addFlashAttribute("message", "Mượn thành công!");
        }

        return "redirect:/book";
    }

    @GetMapping("/pay")
    public String payBook(@RequestParam("payBook") Long code, RedirectAttributes redirectAttributes) {
        UserLendBook userLendBook = userLendBookService.findByLendCode(code);
        if (userLendBook == null) {
            redirectAttributes.addFlashAttribute("message", "Mã sách không tồn tại!");
        } else {
            Book book = bookService.findById(userLendBook.getBook().getId());
            book.setQuantity(book.getQuantity() + 1);

            userLendBookService.remove(userLendBook);
            redirectAttributes.addFlashAttribute("message", "Trả sách thành công!");
        }

        return "redirect:/book";
    }
}
