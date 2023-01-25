package med.voll.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class FirstPageController {

    @GetMapping
    public ResponseEntity<String> greetingMethod(@RequestParam(value = "name", defaultValue = "User") String name) {
        return ResponseEntity.ok().body(String.format("Hello %s!", name));
    }
}
