package com.esipe.ms.service;

import com.esipe.ms.model.User;
import com.esipe.ms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void add(User user){
		System.out.println("add user : " + user.getEmail());
		
		userRepository.save(user);
	}
	
	public User getOne(String email){
		System.out.println("get user by email : " + email);
		
		return userRepository.getOne(email);
	}
	
	public List<User> getAll(){
		return userRepository.getAll();
	}
	
	public void update(User user){
		System.out.println("update user with email : " + user.getEmail());
		
		userRepository.update(user);
	}
	
	public void delete(String email){
		System.out.println("delete user with email : " + email);
		
		userRepository.delete(email);
	}
}
