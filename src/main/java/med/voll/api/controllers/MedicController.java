package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.entities.dto.FormMedicDTO;
import med.voll.api.entities.dto.FormToUpdateMedicDTO;
import med.voll.api.entities.dto.MedicDTO;
import med.voll.api.services.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/medic")
public class MedicController {

    @Autowired
    private MedicService service;

    @GetMapping
    public ResponseEntity<Page<MedicDTO>> findAllMedics(@PageableDefault(page = 0, size = 2, sort = {"name"}) Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicDTO> findAMedicById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createAMedic(@RequestBody @Valid FormMedicDTO medic) {
        service.createAMedic(medic);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medic.getId()).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> upgradeAMedic(@RequestBody FormToUpdateMedicDTO medic, @PathVariable Long id) {
        service.upgradeAMedic(medic, id);
        return ResponseEntity.noContent().build();
    }

}
