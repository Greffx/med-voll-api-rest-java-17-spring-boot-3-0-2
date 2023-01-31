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
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<MedicDTO> createAMedic(@RequestBody @Valid FormMedicDTO medic, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.created(uriBuilder.path("medic/{id}").buildAndExpand(medic.getId()).toUri()).body(service.createAMedic(medic));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormToUpdateMedicDTO> upgradeAMedic(@RequestBody FormToUpdateMedicDTO medic, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.upgradeAMedic(medic, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAMedic(@PathVariable Long id) {
        service.deleteAMedic(id);
        return ResponseEntity.noContent().build();
    }

}
