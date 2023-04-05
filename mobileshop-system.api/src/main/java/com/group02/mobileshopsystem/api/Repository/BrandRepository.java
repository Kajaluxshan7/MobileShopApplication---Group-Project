package com.group02.mobileshopsystem.api.Repository;

import com.group02.mobileshopsystem.api.Model.ProductBrand;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BrandRepository extends JpaRepository<ProductBrand, Long> {

}
