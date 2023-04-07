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
	public List<Products> getProductsByBrand(Long brandId){
		return productRepository.findByBrandId(brandId);
	}
	public List<ProductBrand> getAllBrands(){
		return brandRepository.findAll();
	}
	public Products getProductsById(long productId) throws Exception {
		return productRepository.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
	}
	public List<Products> searchProductsByName(String query) {
		return productRepository.findByNameContainingIgnoreCase(query);
	}
	public List<Products> searchProductsByBrand(long brandId) {
		return productRepository.findByBrandId(brandId);
	}
	public Products addProduct(Products product, Long brandId) {
		return brandRepository.findById(brandId)
				.map(brand -> {
					product.setBrand(brand);
					return productRepository.save(product);
				})
				.orElseThrow(() -> new IllegalArgumentException("Invalid brand id: " + brandId));
	}

	public Products updateProduct(Products product, long brandId) {
		Products existingProduct = productRepository.findById(product.getId()).orElse(null);
		if (existingProduct != null) {
			existingProduct.setName(product.getName());
			existingProduct.setDescription(product.getDescription());
			existingProduct.setPrice(product.getPrice());

			ProductBrand brand = brandRepository.findById(brandId).orElse(null);
			if (brand != null) {
				existingProduct.setBrand(brand);
			}
			productRepository.save(existingProduct);
		}
		return existingProduct;
	}
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
