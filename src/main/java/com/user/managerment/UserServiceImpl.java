package com.user.managerment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public void adduser(UserEntity user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		
		UserEntity userdetails = new UserEntity();
		userdetails.setUserName(user.getUserName());
		userdetails.setPassword(encodedPassword); // Save the encoded password
		userdetails.setUserEmail(user.getUserEmail());
		
		userRepo.save(userdetails);
	}

	@Override
	public UserEntity findByUserName(String userName) {
		
		return userRepo.findByUserName(userName);
		
	}

	@Override
	public List<UserEntity> getAllUsers() {
		
		return userRepo.findAll();
	}

}
