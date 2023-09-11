package com.group02.mobileshopsystem.api.Repository;

import com.group02.mobileshopsystem.api.Model.AddtoCart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AddToCartRepository extends JpaRepository<AddtoCart,Long> {

	@Query("Select sum(addCart.price) FROM AddtoCart addCart WHERE addCart.user_id=:user_id")
	double getTotalAmountByUserId(@Param("user_id")Long user_id);
	@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.user_id=:user_id")
	List<AddtoCart> getCartByuserId(@Param("user_id")Long user_id);
	@Query("Select addCart  FROM AddtoCart addCart ")
	Optional<AddtoCart> getCartByuserIdtest();
	@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.product.id= :product_id and addCart.user_id=:user_id")
	Optional<AddtoCart> getCartByUserAndProductId(@Param("user_id")Long user_id,@Param("product_id")Long product_id);
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE addCart.id =:cart_id   and addCart.user_id=:user_id")
	void deleteCartByIdAndUserId(@Param("user_id")Long user_id,@Param("cart_id")Long cart_id);
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE   addCart.user_id=:user_id")
	void deleteAllCartByUserId(@Param("user_id")Long user_id);
	
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE addCart.user_id=:user_id")
	void deleteAllCartUserId(@Param("user_id")Long user_id);
	@Modifying
    @Transactional
	@Query("update AddtoCart addCart set addCart.quantity=:quantity,addCart.price=:price WHERE addCart.id=:cart_id")
	void updateQuantityByCartId(@Param("cart_id")Long cart_id,@Param("price")double price,@Param("quantity")Integer quantity);

}
