package com.doapp.nanogear.controller;

import com.doapp.nanogear.model.data.Product;
import com.doapp.nanogear.model.respository.ProductRepository;
import com.doapp.nanogear.security.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class productController {

    private final ProductService productService;


    @Autowired
    public productController(ProductService productService) {
        this.productService = productService;
    }

//    @PostMapping("/search")
//    public ResponseEntity<List<Product>> searchProducts(
//            @RequestParam(required = false) String keyword,
//            @RequestParam(required = false) Double price) {
//        List<Product> products = productService.SearchProduct(keyword, price);
//        return ResponseEntity.ok(products);
//    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.findById(id);
    }

//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.save(product);
//    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        Product existingProduct = productService.findById(id);
        if (existingProduct != null) {
            return productService.save(existingProduct);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
    }
}
