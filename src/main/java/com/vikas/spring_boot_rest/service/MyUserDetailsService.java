package com.vikas.spring_boot_rest.service;

import com.vikas.spring_boot_rest.model.UserPrinciple;
import com.vikas.spring_boot_rest.model.user;
import com.vikas.spring_boot_rest.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    private userRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user= repo.findByUsername(username);
        if(user == null){
            System.out.println("user 404");
            throw new UsernameNotFoundException("user not found 404");
        }
        return new UserPrinciple(user);
    }
}
