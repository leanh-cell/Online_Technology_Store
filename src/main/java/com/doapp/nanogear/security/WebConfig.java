package com.doapp.nanogear.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class WebConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Autowired
//    UserService userService;
////    public WebConfig(UserService userService) {
////        this.userService = userService;
////    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(userService.encoder());
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/home") // Trang mặc định sau khi đăng nhập
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/home")
//                .permitAll()
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/index");
//
//        // Cấu hình thêm tùy ý ở đây nếu cần
//
//        // Chặn bảo vệ truy cập tới tất cả các tài nguyên trong thư mục resources
////        http.authorizeRequests()
////                .antMatchers("/resources/**").permitAll()
////                .anyRequest().authenticated();
//    }
//
//
//}
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminAuthenticationInterceptor())
                .addPathPatterns("/admin/**");
    }
}