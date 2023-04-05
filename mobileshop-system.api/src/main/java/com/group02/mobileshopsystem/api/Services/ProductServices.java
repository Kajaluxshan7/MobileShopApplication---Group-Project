package com.group02.mobileshopsystem.api.Services;

import com.group02.mobileshopsystem.api.Model.ProductBrand;
import com.group02.mobileshopsystem.api.Model.Products;
import com.group02.mobileshopsystem.api.Repository.BrandRepository;
import com.group02.mobileshopsystem.api.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServices {
	@Autowired
	ProductRepository productRepository;
	@Autowired
    BrandRepository brandRepository;
	public List<Products>getAllProducts(){
		return productRepository.findAll();
	}
	public List<Products> getProductsByBrand(String product_id){
		return productRepository.getByCategoryId(product_id);
	}
	public List<ProductBrand> getAllBrands(){
		return brandRepository.findAll();
	}
	public Products getProductsById(long productId) throws Exception {
		return productRepository.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
	}
}
