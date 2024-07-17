package com.crud.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.app.dto.ApiResponse;
import com.crud.app.entity.UserEntity;
import com.crud.app.repo.UserRepo;
import com.crud.app.service.UserService;

@RestController
public class contro {
    
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/saveUser")
	public ResponseEntity<ApiResponse<UserEntity>> saveUser(@RequestBody UserEntity userEntity){
		return userService.SaveUserService(userEntity);
	}
	@GetMapping("/getUserData")
	public ResponseEntity<ApiResponse<List<UserEntity>>> getAllUser(){
		return userService.getAllUser();
	}
	@PostMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable(name = "id") String id){
		return userService.deleteById(id);
	}
	
}
	
