package com.group02.mobileshopsystem.api.Repository;

import com.group02.mobileshopsystem.api.Model.ProductBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)

public interface BrandRepository extends JpaRepository<ProductBrand, Long> {

    @Query("SELECT id FROM ProductBrand WHERE  brandName= ?1")
    Long findByBrandName(String name);
}
