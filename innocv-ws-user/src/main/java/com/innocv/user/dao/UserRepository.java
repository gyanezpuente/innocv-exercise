package com.innocv.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.innocv.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}

////Para usar el CRUD directamente
//import org.springframework.data.repository.CrudRepository;
//import com.innocv.exercise.entity.User;
//
//
//public interface UserRepository extends CrudRepository<User, Integer>{
//	
//}