package com.alaynetheodore.cookbook.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.alaynetheodore.cookbook.models.User;
import com.alaynetheodore.cookbook.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	
	public User create(User u) {
		String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashed);
		return userRepo.save(u);
	}
	
	public User getOne(String email) {
		Optional<User> userInDb = userRepo.findByEmail(email);
		return userInDb.isPresent() ? userInDb.get() : null;
	}
	
	public User getOne(Long id) {
		Optional<User> userInDb = userRepo.findById(id);
		return userInDb.isPresent() ? userInDb.get() : null;
	}
	
	public User update(User u) {
		return userRepo.save(u);
	}
}
