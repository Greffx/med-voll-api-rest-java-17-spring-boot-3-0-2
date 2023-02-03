package med.voll.api.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.domain.repositories.UserRepository;
import med.voll.api.domain.services.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService service;

    @Autowired
    private UserRepository repository;


    @Override                        //to get request              //to send something              //represent chain of filters
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (recoverToken(request) != null) {
            var user = repository.findByLogin(service.getSubject(String.valueOf(recoverToken(request))));
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));
        }

        filterChain.doFilter(request, response);
    }

    private Object recoverToken(HttpServletRequest request) {
        return (request.getHeader("Authorization") != null) ?  request.getHeader("Authorization").replace("Bearer", "") : null;
    }
}
