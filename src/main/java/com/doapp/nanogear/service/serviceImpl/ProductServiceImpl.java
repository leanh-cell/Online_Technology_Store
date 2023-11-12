package com.doapp.nanogear.service.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.doapp.nanogear.been.SessionService;
import com.doapp.nanogear.entity.Product;
import com.doapp.nanogear.repository.ProductRepository;
import com.doapp.nanogear.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SessionService sessionService;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String idProduct) {
        return productRepository.findById(idProduct).get();
    }

    @Override
    public List<Product> findAllProductRandom() {
        return productRepository.findAllProductRandom();
    }

    @Override
    public Page<Product> findProductByIdCategory(int idCategory, Optional<Double> min, Optional<Double> max, Optional<Integer> p, Optional<String> s) {
        double minPrice = min.isPresent() ? min.get() * 1000 : Double.MIN_VALUE;
        double maxPrice = max.isPresent() ? max.get() * 1000 : Double.MAX_VALUE;
        if (s.isPresent() && s.get().equals("desc")) {
            System.out.println("Sắp xếp theo DESC");
            Sort sort = Sort.by(Direction.DESC, "price");
            Pageable pageable = PageRequest.of(p.orElse(0), 8, sort);
            return productRepository.findProductByIdCategory(idCategory, minPrice, maxPrice, pageable);
        } else {
            System.out.println("Sắp xếp theo ASC");
            Sort sort = Sort.by(Direction.ASC, "price");
            Pageable pageable = PageRequest.of(p.orElse(0), 8, sort);
            return productRepository.findProductByIdCategory(idCategory, minPrice, maxPrice, pageable);
        }
    }

    @Override
    public Page<Product> findProductByIdBrand(int idBrand, int idCategory, Optional<Double> min, Optional<Double> max, Optional<Integer> p, Optional<String> s) {
        double minPrice = min.isPresent() ? min.get() * 1000 : Double.MIN_VALUE;
        double maxPrice = max.isPresent() ? max.get() * 1000 : Double.MAX_VALUE;
        if (s.isPresent() && s.get().equals("desc")) {
            Sort sort = Sort.by(Direction.DESC, "price");
            Pageable pageable = PageRequest.of(p.orElse(0), 8, sort);
            return productRepository.findProductByIdBrand(idBrand, idCategory, minPrice, maxPrice, pageable);
        } else {
            Sort sort = Sort.by(Direction.ASC, "price");
            Pageable pageable = PageRequest.of(p.orElse(0), 8, sort);
            return productRepository.findProductByIdBrand(idBrand, idCategory, minPrice, maxPrice, pageable);
        }
    }

    @Override
    public void saveProduct(Product product) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Định dạng ngày giờ
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:MM:SS");
        String formattedDateTime = currentDateTime.format(formatter);

//		if (product.getTimeDiscountEnd() == formattedDateTime)
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAllPageProduct(Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 10);
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findByProductKeyWordAndPage(Optional<String> keyWord, Optional<Integer> p) {
        String kw = keyWord.orElse(sessionService.get("keywords", ""));
        sessionService.set("keywords", kw);
        Pageable pageable = PageRequest.of(p.orElse(0), 8);
        return productRepository.findByProductKeyWordAndPage("%" + kw + "%", pageable);
    }

    @Override
    public Double findMinPriceProduct(int idCategory) {
        return productRepository.findMinPriceProduct(idCategory);
    }

    @Override
    public Double findMaxPriceProduct(int idCategory) {
        return productRepository.findMaxPriceProduct(idCategory);
    }

    @Override
    public List<Product> findProductDetailType(int idCategory) {
        List<Product> list = new ArrayList<>();
        int count = 1;
        for (Product product : productRepository.findProductDetailType(idCategory)) {
            if (count <= 4) {
                list.add(product);
                count++;
            }
        }
        return list;
    }

    @Override
    public Double findMaxPriceProductByBrand(int idCategory, int idBrand) {
        return productRepository.findMaxPriceProductByBrand(idBrand, idCategory);
    }

    @Override
    public Double findMinPriceProductByBrand(int idCategory, int idBrand) {
        return productRepository.findMinPriceProductByBrand(idBrand, idCategory);
    }

    @Override
    public Page<Product> getAllProductPage(Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 8);
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getAllProductShare(Optional<String> key, Optional<Integer> p) {
        String keyword = key.orElse(sessionService.get("keywords", ""));
        sessionService.set("keywords", keyword);
        Pageable pageable = PageRequest.of(p.orElse(0), 8);
        return productRepository.getAllProductShare("%" + keyword + "%", pageable);
    }

    @Override
    public void deleteProductById(String idProduct) {
        productRepository.deleteById(idProduct);
    }
//	@Override
//	public List<Product> findAllProductTop10() {
//		return productRepository.findAllProductTop10();
//	}

    @Override
    public List<Product> findAllProductTop10() {
//		List<Top10> listTop10 = new ArrayList<>();
//		int count = 0;
//		for (Top10 list : orderDetailRepository.getTop10()) {
//			if (count > 10) {
//				break;
//			}
//			listTop10.add(list);
//			count++;
//		}
        List<Product> productList = productRepository.getTop10();
        List<Product> products = productList.subList(0, Math.min(productList.size(), 10));
        return products;
    }

    @Override
    public List<Product> findProductsWithDiscount() {
        return productRepository.findProductsWithDiscount();
    }
}
