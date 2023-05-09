package com.taha.pharmacie.security;

import com.taha.pharmacie.entities.User;
import com.taha.pharmacie.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null) {

            org.springframework.security.core.userdetails.User authUser =
                    new org.springframework.security.core.userdetails.User(
                            user.getUsername(),
                            user.getPassword(),
                            user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getRole()))
                                    .collect(Collectors.toList())
                    );
            return authUser;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }


}