package com.example.Laborator11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final List<Product> products = new ArrayList<>();
    public ProductController() {
        products.add(new Product(1, "Mask"));
        products.add(new Product(2, "Gloves"));
    }
    @GetMapping
    public List<Product> getProducts() {
        return products;
    }
    @GetMapping("/count")
    public int countProducts() {
        return products.size();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return products.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public int createProduct(@RequestParam String name) {
        int id = 1 + products.size();
        products.add(new Product(id, name));
        return id;
    }

    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    createProduct(@RequestBody Product product) {
        products.add(product);
        return new ResponseEntity<>(
                "Product created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(
            @PathVariable int id, @RequestParam String name) {
        Product product = findById(id);
        if (product == null) {
            return new ResponseEntity<>(
                    "Product not found", HttpStatus.NOT_FOUND); //or GONE
        }
        product.setName(name);
        return new ResponseEntity<>(
                "Product updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product product = findById(id);
        if (product == null) {
            return new ResponseEntity<>(
                    "Product not found", HttpStatus.GONE);
        }
        products.remove(product);
        return new ResponseEntity<>("Product removed", HttpStatus.OK);
    }

    private Product findById(int id) {
        return null;
    }


}

