package com.myfinalyearproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myfinalyearproject.domain.Booking;
import com.myfinalyearproject.domain.Product;

@Repository
	public interface BookingRepository extends CrudRepository<Booking, Integer> {
		Booking findByid(int id);
	    Booking findByproductid(int productid);
	    List<Booking> findAllByproductid(int productid);
	    Booking findByrenterid(int renterid);
	    List<Booking> findAllByrenterid(int renterid);	
}
