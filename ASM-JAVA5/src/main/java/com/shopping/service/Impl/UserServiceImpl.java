package com.shopping.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.model.UserDtls;
import com.shopping.repository.UserRepository;
import com.shopping.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	  @Autowired
	    private UserRepository userRepository;

	@Override
    public UserDtls saveUser(UserDtls user) {
        return userRepository.save(user);
    }

    @Override
    public UserDtls checklogin(String email, String password) {
        UserDtls user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}
