package com.example.srms.config;

import com.example.srms.domain.dto.UserInfoDto;
import com.example.srms.web.form.SignUpForm;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        // FirstNameとLastNameを結合してFullNameにマッピングする設定
        mapper.addMappings(new PropertyMap<SignUpForm, UserInfoDto>() {
            @Override
            protected void configure() {
                using(new Converter<SignUpForm, String>(){
                    public String convert(MappingContext<SignUpForm, String> context) {
                        return context.getSource().getFirstName() + " "
                                + context.getSource().getLastName();
                    }
                }).map(source, destination.getFullName());
            }
        });
        return mapper;
    }
}
