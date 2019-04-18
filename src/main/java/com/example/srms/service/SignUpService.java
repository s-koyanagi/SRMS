package com.example.srms.service;

import com.example.srms.domain.dao.UserDao;
import com.example.srms.domain.dto.UserInfoDto;
import com.example.srms.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserDao userDao;

    public int userRegistration(UserInfoDto userInfoDto){
        User user = new User();

        //***Passwordハッシュ化ロジック追加***

        user = modelMapper.map(userInfoDto,user.getClass());
        return userDao.insertUser(user);
    }
}
