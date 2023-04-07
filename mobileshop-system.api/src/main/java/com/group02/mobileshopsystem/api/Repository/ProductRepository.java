package com.group02.mobileshopsystem.api.Repository;

import com.group02.mobileshopsystem.api.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
	List<Products> findByBrandId(Long brandId);
	List<Products> findByNameContainingIgnoreCase(String query);

}
