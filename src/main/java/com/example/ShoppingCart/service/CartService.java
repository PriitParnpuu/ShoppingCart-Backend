package com.example.ShoppingCart.service;

import com.example.ShoppingCart.model.Product;
import com.example.ShoppingCart.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

//SERVICE CLASS is for calculations, business logic etc...

@Service
@Transactional
public class CartService {

    private final ProductRepository productRepository;

    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public String addProduct(Product product) {
        productRepository.save(product);
        return "Product added successfully";
    }
    public String removeProduct(Product product) {
        productRepository.delete(product);
        return "Product removed successfully";
    }
    public List<Product> getAllProducts(Product product) {
        List<Product> products;
        return products = productRepository.findAll();
    }
    public String removeProductByName(String name) {
        for (Product product : productRepository.findAll()) {
            if (product.getName().equals(name)) {
                productRepository.delete(product);
            }
        }
        return "Product "+name+" removed successfully";
    }
    //@Scheduled(fixedRate = 10000)
    public double calculateCartTotal() {
        double total = 0;
        for (Product product : productRepository.findAll()) {
            total += product.getPrice() * product.getQuantity();
        }

        System.out.println("Scheduler total: " + total);

        return total;
    }
    public double calculateTax(){

        double total = calculateCartTotal();
        double tax = 0.22;
        return total * tax;
    }
    public double totalPlusTax() {

        double total = calculateCartTotal();
        double tax = calculateTax();
        return total + tax;
    }
    public double discount(){

        double total = calculateCartTotal();
        double discount = 0.1;
        boolean member = false;
        double discountedTotal=0;
        if (member == true) {
            discountedTotal = (calculateCartTotal() - (calculateCartTotal() * discount));
            return discountedTotal;
        }
        else {
            return total;
        }
    }
}


