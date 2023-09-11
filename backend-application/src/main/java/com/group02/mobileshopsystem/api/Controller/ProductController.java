package com.group02.mobileshopsystem.api.Controller;

import com.group02.mobileshopsystem.api.Model.ProductBrand;
import com.group02.mobileshopsystem.api.Model.Products;
import com.group02.mobileshopsystem.api.Services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
	@Autowired
	com.group02.mobileshopsystem.api.Services.ProductServices productServices;
	@Autowired
	BrandService brandService;
	@RequestMapping("/getAll")
	public List<Products> getAllProducts(){
		return productServices.getAllProducts();
	}
	@RequestMapping("/getAllBrands")
	public List<ProductBrand> getAllBrands(){
		return productServices.getAllBrands();
	}
	@RequestMapping("getProductsByBrand")
	public List<Products> getProductsByBrand(@RequestBody HashMap<String,String> request){
		String brand_id = request.get("brand_id");
		return productServices.getProductsByBrand(Long.valueOf(brand_id));
	}
	@PostMapping("/add")
	public ResponseEntity<Products> addProduct(@RequestBody Products product , @RequestParam long brandId) {
		productServices.addProduct(product,brandId);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody Products product, @RequestParam Long brandId) {
		Products updatedProduct = productServices.updateProduct(product, brandId);
		if (updatedProduct == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedProduct);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteProduct(@RequestParam Long id) {
		productServices.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/search")
	public ResponseEntity<List<Products>> searchProductsByName(@RequestParam String query) {
		List<Products> products = productServices.searchProductsByName(query);
		if (products.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(products);
	}
	@GetMapping("/search/brand")
	public ResponseEntity<List<Products>> searchProductsByBrand(@RequestParam String brandName) {
		Long brandId=brandService.getIdByName(brandName);
		if(brandId==null){
			return ResponseEntity.ok(new ArrayList<Products>());
		}
		List<Products> products = productServices.searchProductsByBrand(brandId);
		if (products.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(products);
	}


}
