package com.endriu.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class HeaderAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER
            = new AntPathRequestMatcher("/login", "POST");

    private boolean postOnly = true;

    @Autowired
    public HeaderAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER, authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if(this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        Optional<String> emailHeader = Optional.ofNullable(request.getHeader("email"));
        Optional<String> passwordHeader = Optional.ofNullable(request.getHeader("password"));

        if(emailHeader.isEmpty() || passwordHeader.isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("No required headers found");
        }

        UsernamePasswordAuthenticationToken authRequest
                = new UsernamePasswordAuthenticationToken(emailHeader.get(), passwordHeader.get());

        return this.getAuthenticationManager().authenticate(authRequest);
    }




}
