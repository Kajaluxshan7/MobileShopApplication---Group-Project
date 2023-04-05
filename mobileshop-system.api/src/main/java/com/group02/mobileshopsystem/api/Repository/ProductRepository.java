package com.group02.mobileshopsystem.api.Repository;

import com.group02.mobileshopsystem.api.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
	@Query("Select product FROM Products product WHERE product.branId=:brand_id")
	List<Products> getByCategoryId(@Param("brand_id")String brand_id);
}
