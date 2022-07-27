package vn.codegym.shopping_cart.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.shopping_cart.dto.CartDto;
import vn.codegym.shopping_cart.dto.ProductDto;
import vn.codegym.shopping_cart.model.Product;
import vn.codegym.shopping_cart.service.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping(value = "/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping
    public ModelAndView showProductPage(Model model, @CookieValue(value = "productId", defaultValue = "-1") Long productId) {
        if (productId != -1) {
            model.addAttribute("historyProduct", productService.findById(productId).get());
        }
        return new ModelAndView("product", "productList", productService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailPage(@PathVariable Long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("detail", "product", productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cart, RedirectAttributes redirectAttributes) {
        Optional<Product> product = productService.findById(id);

        if (product.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm vào giỏ hàng thành công!");
            cart.addProduct(productDto);
        }

        return "redirect:/cart";
    }
}
