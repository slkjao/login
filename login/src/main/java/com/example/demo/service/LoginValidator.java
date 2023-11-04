package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginValidator {
	
	
	private String user;
	private String password;
	
	public LoginValidator() {

	}
	
	private Map<String, String> validUsers = new HashMap<>()
			{{
				put("natalie", "cTffjbeW"); //password
				put("jonas", "UT_X\\T"); //baleia
				put("leon", "TeWbTeWb"); //ardoardo
				put("maria", "$%&TUV#,"); //123abc09
				put("joao", "f\\_iXfgXe$%"); //silvester12
			}};
	
	
	public boolean isValid() {
		if(validUsers.containsKey(user) && password.equals(PasswordCryptography.decrypt(validUsers.get(user)))) {
			return true;
		}
		return false;
		
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
