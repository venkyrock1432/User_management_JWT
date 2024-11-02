package com.user.managerment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public String adduser(@RequestBody UserEntity user ) {
		
		if(userService.findByUserName(user.getUserName()) != null) {
			return "Username Already Exists Try with different one";
		}else {
		userService.adduser(user);
		return "Registration Successfully Completed" ;
		}
	}
	
	@GetMapping("/getalluser")
	public List<UserEntity> getAllUsers(){
		return userService.getAllUsers();
		
	}
	
	

}
