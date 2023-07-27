package com.mytrackmysql.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@ComponentScan(basePackages = "com.mytrackmysql")
@Configuration
public class AppConfig implements WebMvcConfigurer {

}
