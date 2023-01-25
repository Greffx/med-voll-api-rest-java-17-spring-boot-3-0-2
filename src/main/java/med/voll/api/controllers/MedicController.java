package med.voll.api.controllers;

import med.voll.api.entities.medic.Medic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/medic")
public class MedicController {


//    @PostMapping
//    public ResponseEntity<Void> createAMedic(@RequestBody Medic medic) {
//        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(service.create(medic).getId()).build());
//    }
}
