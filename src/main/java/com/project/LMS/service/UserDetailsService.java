package com.project.LMS.service;


import com.project.LMS.Dto.UserDto;

public interface UserDetailsService {
	 public UserDto loadUserByUsername(String username);
}