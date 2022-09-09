package com.example.AjaxCall.service;

import java.util.List;

import com.example.AjaxCall.entity.User;


public interface UserService {
	
	public User saveUser(String name,String email,String address);
	
	public List<User> getAllUsers();

	public void deleteUser(int userId);

	public User updateUser(int userId, String name, String email, String address);

}