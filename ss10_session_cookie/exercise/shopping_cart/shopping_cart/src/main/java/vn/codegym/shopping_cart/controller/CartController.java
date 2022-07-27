package vn.codegym.shopping_cart.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.shopping_cart.dto.CartDto;
import vn.codegym.shopping_cart.dto.ProductDto;
import vn.codegym.shopping_cart.model.Product;
import vn.codegym.shopping_cart.service.ProductService;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(name = "cart", required = false) CartDto cart) {
        return new ModelAndView("cartList", "cart", cart);
    }

    @GetMapping("delete")
    public String delete(@RequestParam Long id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            cart.removeProduct(productDto);
        }

        return "redirect:/cart";
    }

    @GetMapping("decrement")
    public String decrement(@RequestParam Long id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            cart.decrementProduct(productDto);
        }

        return "redirect:/cart";
    }

    @GetMapping("increment")
    public String increment(@RequestParam Long id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            cart.addProduct(productDto);
        }

        return "redirect:/cart";
    }
}
