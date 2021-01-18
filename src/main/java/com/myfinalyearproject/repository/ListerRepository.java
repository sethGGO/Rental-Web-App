package com.myfinalyearproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myfinalyearproject.domain.Lister;
import com.myfinalyearproject.domain.User;

@Repository
public interface ListerRepository extends CrudRepository<Lister, Integer>{
//	User findBylisterid(int listerid);
}
