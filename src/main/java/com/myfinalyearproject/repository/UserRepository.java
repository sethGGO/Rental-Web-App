package com.myfinalyearproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myfinalyearproject.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByid(int id);
    User findByemail(String email);
    User findByphonenumber(String phonenumber);
    User findBypassword(String password);
//    List<User> findByphonenumber(String phonenumber);
    }
