package com.crud.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.app.dto.ApiResponse;
import com.crud.app.entity.UserEntity;
import com.crud.app.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	public ResponseEntity<ApiResponse<UserEntity>> SaveUserService(UserEntity userEntity) {
		try {
			UserEntity userSave = userRepo.save(userEntity);
			ApiResponse<UserEntity> response = new ApiResponse<>(userSave, "Successfully Saved", HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			ApiResponse<UserEntity> response = new ApiResponse<>(null, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public ResponseEntity<ApiResponse<List<UserEntity>>> getAllUser() {
		try {
			List<UserEntity> userData = userRepo.findAll();
			ApiResponse<List<UserEntity>> response = new ApiResponse<List<UserEntity>>(userData,"SuccessFully fetched All User",HttpStatus.OK.value());
		    return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			ApiResponse<List<UserEntity>> response = new ApiResponse<List<UserEntity>>(null, "Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 public ResponseEntity<ApiResponse<Void>> deleteById(String id) {
	        try {
	            Long userId = Long.parseLong(id);
	            if (userRepo.existsById(userId)) {
	                userRepo.deleteById(userId);
	                ApiResponse<Void> response = new ApiResponse<>(null, "User deleted successfully", HttpStatus.NO_CONTENT.value());
	                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	            } else {
	                return new ResponseEntity<>(
	                    new ApiResponse<>(null, "User not found", HttpStatus.NOT_FOUND.value()),
	                    HttpStatus.NOT_FOUND
	                );
	            }
	        } catch (NumberFormatException e) {
	            return new ResponseEntity<>(
	                new ApiResponse<>(null, "Invalid user ID", HttpStatus.BAD_REQUEST.value()),
	                HttpStatus.BAD_REQUEST
	            );
	        } catch (Exception e) {
	            return new ResponseEntity<>(
	                new ApiResponse<>(null, "An error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value()),
	                HttpStatus.INTERNAL_SERVER_ERROR
	            );
	        }
	    }
	}
