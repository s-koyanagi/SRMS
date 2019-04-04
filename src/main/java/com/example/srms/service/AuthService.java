package com.example.srms.service;

import com.example.srms.domain.entity.User;
import com.example.srms.domain.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserDao userDao; // repositoryを指定

    @Override
    public UserDetails loadUserByUsername(String esqId) throws UsernameNotFoundException {

        if(esqId == null || "".equals(esqId)) {
            throw new UsernameNotFoundException("ユーザーIDが未入力です");
        }

        User user = userDao.selectByUserId(esqId);
        if(user == null) {
            throw new UsernameNotFoundException("ユーザーIDが不正です。");
        }

        return user;
    }
}