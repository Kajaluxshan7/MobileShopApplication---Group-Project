package com.group02.mobileshopsystem.api.Services;

import com.group02.mobileshopsystem.api.Model.AddtoCart;
import com.group02.mobileshopsystem.api.Model.CheckoutCart;
import com.group02.mobileshopsystem.api.Model.Products;
import com.group02.mobileshopsystem.api.Repository.AddToCartRepository;
import com.group02.mobileshopsystem.api.Repository.CheckoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CartServiceImpl implements CartService {
	@Autowired
    AddToCartRepository addToCartRepository;
	@Autowired
	CheckoutRepository checkoutRepository;
	@Autowired
	ProductServices productServices;
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

	@Override
	public List<AddtoCart> addToCartByUserIdAndProductId(long productId, long userId, int quantity, double price) throws Exception {
		try {
			if(addToCartRepository.getCartByUserAndProductId(userId, productId).isPresent()){
				throw new Exception("Product already exist.");
			}
			AddtoCart obj = new AddtoCart();
			obj.setQuantity(quantity);
			obj.setUser_id(userId);
			Products product = productServices.getProductsById(productId);
			obj.setProduct(product);
			if(quantity>product.getQuantity()){
				return null;
			}
			obj.setPrice(price);
			addToCartRepository.save(obj);
			return this.getCartByUserId(userId);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<AddtoCart> getCartByUserId(long userId) {
		return addToCartRepository.getCartByuserId(userId);
	}

	@Override
	public List<AddtoCart> removeCartByUserId(long cartId, long userId) {
		addToCartRepository.deleteCartByIdAndUserId(userId, cartId);
		return this.getCartByUserId(userId);
	}

	@Override
	public void updateQuantityByCartId(long cartId, int qty, double price) throws Exception {
		addToCartRepository.updateQuantityByCartId(cartId,price,qty);
	}

	@Override
	public Boolean checkTotalAmountAgainstCart(double totalAmount,long userId) {
		double total_amount = addToCartRepository.getTotalAmountByUserId(userId);
		if(total_amount == totalAmount) {
			return true;
		}
		System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
		return false;
	}

	@Override
	public List<CheckoutCart> getAllCheckoutByUserId(long userId) {
		return checkoutRepository.getByUserId(userId);
	}

	@Override
	public List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp) throws Exception {
		try {
			long user_id = tmp.get(0).getUser_id();
			if(tmp.size() >0) {
				checkoutRepository.saveAll(tmp);
				this.removeAllCartByUserId(user_id);
				return this.getAllCheckoutByUserId(user_id);
			}	
			else {
				throw  new Exception("Should not be empty");
			}
		}catch(Exception e) {
			throw new Exception("Error while checkout "+e.getMessage());
		}
		
	}

	@Override
	public List<AddtoCart> removeAllCartByUserId(long userId) {
		addToCartRepository.deleteAllCartByUserId(userId);
		return null;
	}

}
