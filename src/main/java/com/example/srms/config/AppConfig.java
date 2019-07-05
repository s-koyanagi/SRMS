package com.example.srms.config;

import com.example.srms.domain.dto.SeminarDTO;
import com.example.srms.domain.dto.SignUpDTO;
import com.example.srms.domain.entity.Seminar;
import com.example.srms.web.form.SignUpForm;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        // FirstNameとLastNameを結合してFullNameにマッピングする設定
        mapper.addMappings(new PropertyMap<SignUpForm, SignUpDTO>() {
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

        mapper.addMappings(new PropertyMap<Seminar, SeminarDTO>() {
            @Override
            protected void configure() {
                using(new Converter<Seminar, String>(){
                    public String convert(MappingContext<Seminar, String> context) {
                        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy年MM月dd日");
                        String eventDate = sdfDate.format(context.getSource().getStartedTime().getTime());
                        return eventDate;
                    }
                }).map(source, destination.getEventDate());

                using(new Converter<Seminar, String>(){
                    public String convert(MappingContext<Seminar, String> context) {
                        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm");
                        String startTime = sdfTime.format(context.getSource().getStartedTime().getTime());
                        return startTime;
                    }
                }).map(source, destination.getStartedTime());

                using(new Converter<Seminar, String>(){
                    public String convert(MappingContext<Seminar, String> context) {
                        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm");
                        String endTime = sdfTime.format(context.getSource().getClosedTime().getTime());
                        return endTime;
                    }
                }).map(source, destination.getClosedTime());

            }
        });



        return mapper;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
