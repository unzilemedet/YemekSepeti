package com.unzilemedet.repository;

import com.unzilemedet.entity.Customer;
import com.unzilemedet.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {

    public List<Order> findAllByCustomerId(Long customerId);


}
