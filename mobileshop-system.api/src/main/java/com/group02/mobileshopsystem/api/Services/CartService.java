package com.group02.mobileshopsystem.api.Services;

import com.group02.mobileshopsystem.api.Model.AddtoCart;
import com.group02.mobileshopsystem.api.Model.CheckoutCart;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartService {
	List<AddtoCart> addToCartByUserIdAndProductId(long productId, long userId, int quantity, double price) throws Exception;
	void updateQuantityByCartId(long cartId, int quantity, double price) throws Exception;
	List<AddtoCart> getCartByUserId(long userId);
	List<AddtoCart> removeCartByUserId(long cartId,long userId);
	List<AddtoCart> removeAllCartByUserId(long userId);
	Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);
	List<CheckoutCart> getAllCheckoutByUserId(long userId);
	List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;

}
