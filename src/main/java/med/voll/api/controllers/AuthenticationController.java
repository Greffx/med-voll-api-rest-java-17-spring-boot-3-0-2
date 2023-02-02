package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.domain.entities.dto.security.AuthenticationDataDTO;
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

    @PostMapping
    public ResponseEntity<Void> loginInto(@RequestBody @Valid AuthenticationDataDTO data) {
        System.out.println(data.getLogin() + " " + data.getPassword());
        manager.authenticate(new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword()));
        return ResponseEntity.ok().build();
    }
}
