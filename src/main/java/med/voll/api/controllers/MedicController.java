package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.entities.dto.MedicDTO;
import med.voll.api.services.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/medic")
public class MedicController {

    @Autowired
    private MedicService service;

    @GetMapping
    public ResponseEntity<List<MedicDTO>> findAllMedics() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> createAMedic(@RequestBody @Valid MedicDTO medic) {
        service.createAMedic(medic);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medic.getId()).toUri()).build();
    }
}
