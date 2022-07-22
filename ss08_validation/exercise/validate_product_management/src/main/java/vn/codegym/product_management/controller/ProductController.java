package vn.codegym.product_management.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.product_management.dto.ProductDto;
import vn.codegym.product_management.model.Product;
import vn.codegym.product_management.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Product> products = productService.findAll(pageable);
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("productDto") ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Add Product Successful!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("productDto", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("productDto") ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }

        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.save(product);
        redirect.addFlashAttribute("success", "Update product successfully!");

        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());

        redirect.addFlashAttribute("success", "Removed product successfully!");

        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @PostMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<Product> products = productService.searchByKeyword(keyword);
        model.addAttribute("products", products);
        return "/index";
    }
}
