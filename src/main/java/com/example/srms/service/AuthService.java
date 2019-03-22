package com.example.srms.service;

import com.example.srms.domain.entity.UserInfo;
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
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        if(userId == null || "".equals(userId)) {
            throw new UsernameNotFoundException("ユーザーIDが未入力です");
        }

        UserInfo userInfo = userDao.selectByUserId(userId);
        if(userInfo == null) {
            throw new UsernameNotFoundException("ユーザーIDが不正です。");
        }

        return userInfo;
    }
}