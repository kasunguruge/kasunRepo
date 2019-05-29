package com.kasun.oauth.example.authexample.service;

import com.kasun.oauth.example.authexample.model.AuthUserDetail;
import com.kasun.oauth.example.authexample.model.User;
import com.kasun.oauth.example.authexample.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailRepository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {


        Optional<User> optionalUser = userDetailRepository.findByUsername(name);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;

    }
}
