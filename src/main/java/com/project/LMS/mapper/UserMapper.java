package com.project.LMS.mapper;

import org.springframework.stereotype.Component;
import com.project.LMS.Dto.UserDto;
import com.project.LMS.models.User;

@Component
public class UserMapper {

	public User mapToUser(UserDto userdto) {
		User user = new User(userdto.getId(), userdto.getUsername(), userdto.getPassword(),userdto.getRole());
		return user;
	}

   public UserDto mapToUserDto(User user) {
	   UserDto userdto= new UserDto(user.getId() ,user.getUsername(), user.getPassword(),user.getRole());
		return userdto;
	}
				
}
