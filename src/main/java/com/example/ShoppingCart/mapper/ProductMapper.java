package com.example.ShoppingCart.mapper;

import com.example.ShoppingCart.dto.ProductDTO;
import com.example.ShoppingCart.model.Product;

public class ProductMapper {

        // Convert Product entity to ProductDTO
        public static ProductDTO toDTO(Product product) {
            if (product == null) {
                return null;
            }

            return new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity()

            );
        }

        // Convert ProductDTO to Product entity
        public static Product toEntity(ProductDTO productDTO) {
            if (productDTO == null) {
                return null;
            }

            Product product = new Product();
            product.setId(productDTO.getId());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setQuantity(productDTO.getQuantity());
            // The total is not explicitly set, as it's derived from price and quantity

            return product;
        }
}


