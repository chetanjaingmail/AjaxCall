package com.example.AjaxCall.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.AjaxCall.entity.User;
import com.example.AjaxCall.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service ;
	
@PostMapping("/saveUser")	
public @ResponseBody String saveUser(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("address") String address) throws JSONException {
	User user = service.saveUser(name, email, address);
	JSONObject resObj = new JSONObject();
	resObj.put("id",user.getId());
	resObj.put("name", user.getName());
	resObj.put("email", user.getEmail());
	resObj.put("address", user.getAddress());
	return resObj.toString() ;
}

@GetMapping("/users")	
public @ResponseBody List<User> getAll(){
	List<User>userList = service.getAllUsers();
	return userList ;
}

@GetMapping("/deleteUser")
public @ResponseBody void deleteUser(@RequestParam("userId")int userId) {
	service.deleteUser(userId);
}

@PostMapping("/updateUser")
public @ResponseBody String updateUser( @RequestParam("userId") int userId,
		                             @RequestParam("name") String name,
		                             @RequestParam("email") String email,
		                             @RequestParam("address") String address) throws JSONException {
	
	System.out.println("inside save user controller.......");
	  User user = 	service.updateUser(userId,name, email,address);
	  
	  JSONObject resObj = new JSONObject();
	  resObj.put("id", user.getId());
	  resObj.put("name", user.getName());
	  resObj.put("email", user.getEmail());
	  resObj.put("address", user.getAddress());
	  
	return resObj.toString();
}

}
