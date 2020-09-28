package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser=this.userRepository.findByUsername(username);
        if(appUser==null){
            System.out.println("User not found!"+username);
        }
        System.out.println("Found User:"+appUser);
        Role roleName=appUser.getRole();
        List<GrantedAuthority> grantList=new ArrayList<GrantedAuthority>();
        GrantedAuthority authority=new SimpleGrantedAuthority(roleName.getRoleName());
        grantList.add(authority);
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(appUser.getUsername(), //
                appUser.getPassword(), grantList);
        return userDetails;
    }
}
