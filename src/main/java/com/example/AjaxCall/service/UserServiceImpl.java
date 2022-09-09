package com.example.AjaxCall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AjaxCall.entity.User;
import com.example.AjaxCall.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
@Autowired
UserRepo repo ;
	@Override
	public User saveUser(String name, String email, String address) {
		// TODO Auto-generated method stub
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setAddress(address);
		return repo.save(u);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User>userList = repo.findAll();
		return userList;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
User user = repo.getById(userId);
		repo.delete(user);
}

	@Override
	public User updateUser(int userId, String name, String email, String address) {
		// TODO Auto-generated method stub
		User dbUser = repo.getById(userId);
		User user = null ;
		if(null != dbUser) {
			dbUser.setName(name);
			dbUser.setEmail(email);
			dbUser.setAddress(address);
			user = repo.save(dbUser);
		}
		return user;
	}

}
