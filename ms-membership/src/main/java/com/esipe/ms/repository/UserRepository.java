package com.esipe.ms.repository;

import com.esipe.ms.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("Users")
public class UserRepository {

	private static Map<String, User> users = new HashMap<>();

	static {
		users.put("Admin", new User());
	}

	public void save(User user){
		
		users.put(user.getEmail(), user);
	}
	
	public void update(User user){
		
		if(!ifExiste(user.getEmail())){
			throw new RuntimeException("user not found");
		}
		
		users.put(user.getEmail(), user);
	}
	
	public User getOne(String email){
		
		return users.get(email);
	}
	
	public void delete(String email){
		
		if(!ifExiste(email)){
			throw new RuntimeException("user not found");
		}
		
		users.remove(email);
	}
	
	private boolean ifExiste(String email){
		return users.containsKey(email);
	}

	public List<User> getAll() {
		return new ArrayList<User>(users.values());
	}
	
	
}
