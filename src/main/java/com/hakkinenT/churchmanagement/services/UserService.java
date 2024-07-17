package com.hakkinenT.churchmanagement.services;

import com.hakkinenT.churchmanagement.models.entities.Role;
import com.hakkinenT.churchmanagement.models.entities.User;
import com.hakkinenT.churchmanagement.models.projections.UserDetailsProjection;
import com.hakkinenT.churchmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsProjection result = userRepository.searchUserAndRolesByEmail(username);
        if(result == null){
            throw new UsernameNotFoundException("User not found");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.getPassword());
        user.setRole(new Role(result.getRoleId(), result.getAuthority()));

        return user;
    }
}