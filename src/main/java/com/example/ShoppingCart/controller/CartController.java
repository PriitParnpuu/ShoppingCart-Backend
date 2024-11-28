package com.example.ShoppingCart.controller;

import com.example.ShoppingCart.model.Product;
import com.example.ShoppingCart.repository.ProductRepository;
import com.example.ShoppingCart.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")


public class CartController {

    private final CartService CartService;
    private final ProductRepository productRepository;
    private final CartService cartService;

    public CartController(CartService CartService, ProductRepository productRepository, CartService cartService) {
        this.CartService = CartService;
        this.productRepository = productRepository;
        this.cartService = cartService;
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hallooo";
    }

    @PostMapping("/add-product")
    public String addProduct(@RequestBody Product product) {
        return CartService.addProduct(product);
    }

    @GetMapping("/cart-items")
    public List<Product> getCartItems(Product product) {
        return CartService.getAllProducts(product);
    }

    @DeleteMapping("delete-product/{name}")
    public String deleteProductByName(@PathVariable("name") String name) {
        return cartService.removeProductByName(name);
    }

    @GetMapping("/cart-total")
    public double calculateCartTotal() {
        return CartService.calculateCartTotal();
    }

    @GetMapping("/cart-tax")
    public double calculateTax() {
        return CartService.calculateTax();
    }

    @GetMapping("/cart-taxedtotal")
    public double totalPlusTax() {
        return CartService.totalPlusTax();
    }
}


