package com.group02.mobileshopsystem.api.Services;

import com.group02.mobileshopsystem.api.Model.ProductBrand;
import com.group02.mobileshopsystem.api.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Long getIdByName(String brandName){
        Long id=brandRepository.findByBrandName(brandName);
        return id;
    }
    public List<ProductBrand> getAllProductBrands() {

        return brandRepository.findAll();
    }

    public ProductBrand addCategory(ProductBrand productBrand) {
        return brandRepository.save(productBrand);

    }
    public ProductBrand  updateCategory(Long id, ProductBrand category) {
        Optional<ProductBrand > optionalProductBrand = brandRepository.findById(id);
        if (optionalProductBrand.isPresent()) {
            ProductBrand  existingBrand = optionalProductBrand.get();
            existingBrand.setName(category.getName());
            return brandRepository.save(existingBrand);
        } else {
            throw new RuntimeException("No Such Brand Found");
        }
    }
    public void deleteBrandById(Long brandId) {

        brandRepository.deleteById(brandId);

    }
}
