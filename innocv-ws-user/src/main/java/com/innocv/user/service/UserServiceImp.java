/**
 * 
 */
package com.innocv.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innocv.user.dao.UserRepository;
import com.innocv.user.model.User;

/**
 * @author usuario
 *
 */
@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository dao;

	/**
	 * 
	 */
	public UserServiceImp() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.innocv.exercise.service.UserService#get(java.lang.Integer)
	 */
	@Override
	public Optional<User> get(Integer id) {
		return this.dao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.innocv.exercise.service.UserService#getAll()
	 */
	@Override
	public List<User> getAll() {
		return this.dao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.innocv.exercise.service.UserService#create(com.innocv.exercise.entity.User)
	 */
	@Override
	public void create(User user) {
		this.dao.save(user);

	}

	/* (non-Javadoc)
	 * @see com.innocv.exercise.service.UserService#update(com.innocv.exercise.entity.User)
	 */
	@Override
	public void update(User user) {
		this.dao.findById(user.getId()).ifPresent(userold -> {
			userold.setName(user.getName());
			userold.setBirthdate(user.getBirthdate());
			this.dao.save(userold);
		});;

	}

	/* (non-Javadoc)
	 * @see com.innocv.exercise.service.UserService#remove(java.lang.Integer)
	 */
	@Override
	public void remove(Integer id) {
		this.dao.deleteById(id);
	}

}
