package com.unzilemedet.repository.joinrepository;

import com.unzilemedet.entity.jointable.RestaurantOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRestaurantOrderRepository extends JpaRepository<RestaurantOrder,Long> {
    @Query(value = "SELECT p.id,p.name FROM order_product_id AS o_d\n" +
            "INNER JOIN product AS p  ON p.id=o_d.product_id\n" +
            "WHERE p.restaurant_id= ?1",nativeQuery = true)
    List<RestaurantOrder> findAllRestaurantOrder(Long restaurantId);
}
