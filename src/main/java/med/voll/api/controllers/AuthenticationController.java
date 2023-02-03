package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.domain.entities.User;
import med.voll.api.domain.entities.dto.security.AuthenticationDataDTO;
import med.voll.api.domain.entities.dto.security.TokenJwtDTO;
import med.voll.api.domain.services.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService service;

    @PostMapping
    public ResponseEntity<TokenJwtDTO> loginInto(@RequestBody @Valid AuthenticationDataDTO data) {
        return ResponseEntity.ok().body(new TokenJwtDTO(
                service.generateToken((User) manager.authenticate(new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword())).getPrincipal())));
    }
}
