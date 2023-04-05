package com.group02.mobileshopsystem.api.Controller;

import com.group02.mobileshopsystem.api.Model.ProductBrand;
import com.group02.mobileshopsystem.api.Model.Products;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
	@Autowired
	com.group02.mobileshopsystem.api.Services.ProductServices ProductServices;
	@RequestMapping("getAll")
	public List<Products> getAllProducts(){
		return ProductServices.getAllProducts();
	}
	@RequestMapping("getAllBrands")
	public List<ProductBrand> getAllBrands(){
		return ProductServices.getAllBrands();
	}
	@RequestMapping("getProductsByBrand")
	public List<Products> getProductsByBrand(@RequestBody HashMap<String,String> request){
		String brand_id = request.get("brand_id");
		return ProductServices.getProductsByBrand(brand_id);
	}
	@GetMapping( value = "/getimage/{img_name}",produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable("img_name") String img_name) throws IOException {
	    InputStream in = getClass().getResourceAsStream("/images/"+img_name);
	    return IOUtils.toByteArray(in);
	}
}
