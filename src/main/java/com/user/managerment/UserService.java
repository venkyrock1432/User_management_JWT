package com.user.managerment;

import java.util.List;

public interface UserService {
	
	public void adduser(UserEntity user);
	
	public UserEntity findByUserName(String userName);
	
	public List<UserEntity> getAllUsers();

}
