package com.unzilemedet.repository;

import com.unzilemedet.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Long> {
    public Boolean existsByAddress(String address);
}
