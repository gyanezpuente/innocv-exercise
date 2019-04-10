package com.innocv.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innocv.user.dao.UserRepository;
import com.innocv.user.exception.ResourceNotFoundException;
import com.innocv.user.model.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;	
	
	@GetMapping("/users")
	public List<User> getAll() {
		return this.userRepository.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> get(@PathVariable(value = "id") int userId) throws ResourceNotFoundException {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/users")
	public User create(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/users/{id}")
	  public ResponseEntity<User> update(@PathVariable(value = "id") int userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		user.setName(userDetails.getName());
		user.setBirthdate(userDetails.getBirthdate());
		final User updatedUser = userRepository.save(user);
	    return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/user/{id}")
	  public Map<String, Boolean> remove(@PathVariable(value = "id") int userId) throws Exception {
	    User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
	    userRepository.delete(user);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }

}
