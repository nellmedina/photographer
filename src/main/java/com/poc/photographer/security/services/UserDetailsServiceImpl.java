package com.poc.photographer.security.services;

import com.poc.photographer.model.UserEntity;
import com.poc.photographer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
    	
        UserEntity user = userRepository.findByEmail(email)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> email : " + email)
        );

        return com.poc.photographer.security.services.UserPrinciple.build(user);
    }

}