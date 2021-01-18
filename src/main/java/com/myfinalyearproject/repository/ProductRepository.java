package com.myfinalyearproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myfinalyearproject.domain.Booking;
import com.myfinalyearproject.domain.Product;
import com.myfinalyearproject.domain.User;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	Product findByid(int id);
    Product findBylister(String lister);
    List<Product> findAllBylister(String lister);
}
