package com.vikas.spring_boot_rest.repo;



import com.vikas.spring_boot_rest.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<user, Integer>
{
 user findByUsername(String username);

}
