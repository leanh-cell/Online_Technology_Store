package com.doapp.nanogear.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doapp.nanogear.dto.ProductCategoryCount;
import com.doapp.nanogear.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	
	@Query(value = "SELECT TOP 8 * FROM product\r\n"
			+ "ORDER BY NEWID()", nativeQuery = true)
	List<Product> findAllProductRandom();
	
//	@Query("select p from Product p where p.category.id=:id")
//	List<Product> findProductByIdCategory(@Param("id") int idCategory);

	@Query("SELECT p FROM Product p WHERE p.discount > 0")
	List<Product> findProductsWithDiscount();

	@Query("select p from Product p where p.category.id=:id and p.price between :min and :max ")
	Page<Product> findProductByIdCategory(@Param("id") int idCategory,@Param("min") double min, @Param("max") double max, Pageable pageable);
	
	@Query("select p from Product p where p.brand.id=:idBrand and p.category.id=:idCategory and p.price between :min and :max")
	Page<Product> findProductByIdBrand(@Param("idBrand") int idBrand, @Param("idCategory") int idCategory,@Param("min") double min, @Param("max") double  max, Pageable pageable);
	
	@Query("select p from Product p where p.name like ?1")
	Page<Product> findByProductKeyWordAndPage(@Param("name") String nameProduct, Pageable pageable);
	
	@Query("select min(p.price) from Product p where p.category.id =:id")
	Double findMinPriceProduct(@Param("id") int idCategory);
	
	@Query("select max(p.price) from Product p where p.category.id =:id ")
	Double findMaxPriceProduct(@Param("id") int idCategory);
	
	@Query("select min(p.price) from Product p where p.brand.id=:idBrand and p.category.id=:idCategory ")
	Double findMinPriceProductByBrand(@Param("idBrand") int idBrand, @Param("idCategory") int idCategory);
	
	@Query("select max(p.price) from Product p where p.brand.id=:idBrand and p.category.id=:idCategory ")
	Double findMaxPriceProductByBrand(@Param("idBrand") int idBrand, @Param("idCategory") int idCategory);
	
//	@Query("select p from Product p where p.category.id =:id")
//	List<Product> findProductDetailType(@Param("id") int idCategory);
	
	@Query("select p from Product p where p.category.id =:id ")
	List<Product> findProductDetailType(@Param("id") int idCategory);
	
	@Query(value = "SELECT TOP 10 * FROM product WHERE sold_quantity > 0 ORDER BY sold_quantity DESC", nativeQuery = true)
	List<Product> findAllProductTop10();
	
	@Query("select new com.doapp.nanogear.dto.ProductCategoryCount( o.category.name, count(o)) from Product o group by o.category.id, o.category.name")
	List<ProductCategoryCount> getCountProductByCategory();

	@Query("select p from Product p where p.name like ?1 or p.id like ?1 or p.brand.name like ?1 or p.category.name like ?1")
	Page<Product> getAllProductShare(String key, Pageable pageable);
	
//	@Query("select new ProductCategoryCount(p.name) from product p")
//	List<ProductCategoryCount> getCountProductByCategory();
	
//	@Query("SELECT new com.doapp.nanogear.dto.Report(o.category, sum(o.price), count(o)) "
//			+ " FROM Product o "
//			+ " GROUP BY o.category"
//			+ " ORDER BY sum(o.price) DESC")
//	List<Report> getInventoryByCategory();

	@Query("SELECT p FROM Product p ORDER BY p.soldQuantity DESC")
	List<Product> getTop10();
}
