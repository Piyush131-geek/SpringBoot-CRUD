package com.crud.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.app.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long>  {
}
