package com.shopping.service;

import com.shopping.model.UserDtls;

public interface UserService {
	public UserDtls saveUser(UserDtls user);
	public UserDtls checklogin(String password, String email);
}