package com.doapp.nanogear.security;

import com.doapp.nanogear.model.data.Product;
import com.doapp.nanogear.model.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> SearchProduct(String name , double price){
       return productRepository.searchProducts(name,price);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    };

    public Product save(Product theProduct) {
       return productRepository.save(theProduct);

    }
    public Product findById(int theId) {
        Optional<Product> result = productRepository.findById(theId);

        return result.orElseThrow(() -> new RuntimeException("Did not find product id - " + theId));
    }

    public void deleteById(int theId) {
        productRepository.deleteById(theId);
    }
}
