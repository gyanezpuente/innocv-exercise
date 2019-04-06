package com.innocv.user.service;

import java.util.List;
import java.util.Optional;

import com.innocv.user.model.User;

public interface UserService {
	
	
	/**
	 * return an user if exist
	 * @param id
	 * @return
	 */
	Optional<User> get (Integer id);
	
	/**
	 * Returns a list of all users
	 * @return
	 */
	List<User> getAll ();	
	
	/**
	 * creates an user
	 * @param user
	 */
	void create (User user);
	
	/**
	 * udate data user
	 * @param user
	 */
	void update (User user);
	
	/**
	 * delete a user
	 * @param user
	 */
	void remove (Integer id);

}
