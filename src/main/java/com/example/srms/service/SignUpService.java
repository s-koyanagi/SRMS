package com.example.srms.service;

import com.example.srms.domain.dao.UserDao;
import com.example.srms.domain.dto.SignUpInfoDto;
import com.example.srms.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserDao userDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String MASK_PASSWORD = "*****";
    private static final int SUCCESSFUL_REGISTER=1;
    private static final int FAILURE_REGISTER=0;
    private static final int NO_INSERT_RESULT=0;

    public SignUpInfoDto userRegistration(SignUpInfoDto signUpInfoDto){
        User user = new User();
        signUpInfoDto.setMaskPassword(signUpInfoDto.getPassword().substring(0,3)+MASK_PASSWORD);
        signUpInfoDto.setPassword(bCryptPasswordEncoder.encode(signUpInfoDto.getPassword()));
        user = modelMapper.map(signUpInfoDto,user.getClass());
        if(userDao.insertUser(user)==NO_INSERT_RESULT){
            signUpInfoDto.setIsRegister(FAILURE_REGISTER);
            return signUpInfoDto;
        }
        signUpInfoDto.setIsRegister(SUCCESSFUL_REGISTER);
        return signUpInfoDto;
    }
}
