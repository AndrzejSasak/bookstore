package com.endriu.bookstore.config;

import com.endriu.bookstore.config.CustomUserDetailsService;
import com.endriu.bookstore.config.HeaderAuthenticationFilter;
import com.endriu.bookstore.repository.CustomerRepository;
import com.endriu.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomerService customerService;

    @Autowired
    public SecurityConfig(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(getCustomFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .logout(logout -> logout.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()));
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService(customerService))
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public UserDetailsService userDetailsService(CustomerService customerService) {
        return new CustomUserDetailsService(customerService);
    }

    @Bean
    public static PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private HeaderAuthenticationFilter getCustomFilter() throws Exception {
        HeaderAuthenticationFilter headerAuthenticationFilter
                = new HeaderAuthenticationFilter(authenticationManagerBean());
        headerAuthenticationFilter.setAuthenticationFailureHandler(
                (request, response, exception) -> response.setStatus(HttpStatus.UNAUTHORIZED.value()));
        headerAuthenticationFilter.setAuthenticationSuccessHandler(
                (request, response, authentication) -> response.setStatus(HttpStatus.OK.value()));
        return headerAuthenticationFilter;
    }
}
