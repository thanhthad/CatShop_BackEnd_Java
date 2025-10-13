package com.catshop.catshop.config;

import com.catshop.catshop.entity.Role;
import com.catshop.catshop.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleSeeder implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        List<String> defaultRoles = List.of("Customer","Admin");
        for(String roles : defaultRoles){
            if(!roleRepository.existsByRoleName(roles)){
                Role role = Role.builder().roleName(roles).build();
                roleRepository.save(role);
                System.out.println("Insered Role: "+roles);
            }else {
                System.out.println("Role " + roles +" already existed!");
            }
        }
    }
}
