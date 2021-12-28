package com.maqcoding.sbmongoresponseexceptionerrorhandling.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.maqcoding.sbmongoresponseexceptionerrorhandling.model.Student;

import java.lang.String;
import java.util.List;

public interface StudentRepo extends MongoRepository<Student, Integer>,StudentRepoTemplate{

	List<Student> findByName(String name);

	@Query("{'Address.city':?0}")
	List<Student> findByCity(String city);
	
	@Query("{'Products.name':?0}")
	List<Student> findByProductName(String name);
	
	
	
	
}
