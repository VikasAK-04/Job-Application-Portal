package com.vikas.spring_boot_rest.service;


import com.vikas.spring_boot_rest.model.user;
import com.vikas.spring_boot_rest.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private userRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        public user saveData(user user){
            user.setPassword(encoder.encode(user.getPassword()));
            System.out.println(user.getPassword());
        return repo.save(user);
    }


}
