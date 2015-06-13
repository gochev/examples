package org.gochev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(LoginService.NAME)
public class LoginService {
	
	public final static String NAME = "loginService";
	
	@Autowired
	private UserService userService;

	public boolean login(String username, String password){
		return userService.findUser(username, password);
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
