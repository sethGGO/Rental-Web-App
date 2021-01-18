package com.myfinalyearproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myfinalyearproject.domain.Renter;
import com.myfinalyearproject.domain.User;

@Repository
public interface RenterRepository extends CrudRepository<Renter, Integer>{
//	User findByrenterid(int renterid);
}
