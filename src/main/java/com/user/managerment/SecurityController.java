package com.user.managerment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SecurityController {
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtility jwtUtility;
    

    @GetMapping("/login")
   public String generateToken(@RequestParam String userName, @RequestParam String password) throws Exception {
    	
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userName,password)
            );
        } catch (AuthenticationException e) {
            throw new Exception("Invalid username/password");
        }
        
        final UserDetails userDetails= myUserDetailsService.loadUserByUsername(userName);
        return "Login successful - " + jwtUtility.generateToken(userName);
    }

}
