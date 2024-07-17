package com.project.LMS.service.ServiceImpl;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.project.LMS.Dao.UserRepository;
import com.project.LMS.models.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
   // private  UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username)  {
    	 User user = userRepository.findByUsername(username); // Fetch your User entity
               //  .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

         // Convert User to UserDetails if needed (e.g., using UserMapper)
         // UserDetails userDetails = userMapper.toUserDetails(user); 
         
         // Or directly return the Spring Security User object if findByUsername returns that type
         return new org.springframework.security.core.userdetails.User(
             user.getUsername(),
             user.getPassword(), // Hash from DB
             user.getRole().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList())
         );
     }
 
    	 
    	
    }
        

