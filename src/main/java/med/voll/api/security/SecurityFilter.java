package med.voll.api.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.domain.services.security.TokenService;
import med.voll.api.security.exception.TokenNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService service;


    @Override                        //to get request              //to send something              //represent chain of filters
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        service.getSubject(String.valueOf(recoverToken(request)));

        filterChain.doFilter(request, response);
    }

    private Object recoverToken(HttpServletRequest request) {
        return (request != null) ?  request.getHeader("Authorization").replace("Bearer", "") : new TokenNotFoundException("Token can't be null.");
    }
}
