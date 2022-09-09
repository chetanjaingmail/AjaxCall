package com.example.AjaxCall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AjaxCall.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
