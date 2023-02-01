package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.domain.entities.dto.patient.FormPatientDTO;
import med.voll.api.domain.entities.dto.patient.FormUpdatePatientDTO;
import med.voll.api.domain.entities.dto.patient.PatientDetailedDTO;
import med.voll.api.domain.entities.dto.patient.TypeForListPatientDTO;
import med.voll.api.domain.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping
    public ResponseEntity<Page<TypeForListPatientDTO>> findAllWithPageable(@PageableDefault(page = 0, size = 10, sort = {"name"}) Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllPatients(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDetailedDTO> findPatientById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findByIdPatient(id));
    }

   @PostMapping
    public ResponseEntity<FormPatientDTO> create(@RequestBody @Valid FormPatientDTO patient, UriComponentsBuilder builder) {
        return ResponseEntity.created(builder.path("patient/{id}").buildAndExpand(patient.getId()).toUri()).body(service.createAPatient(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDetailedDTO> updatePatient(@RequestBody FormUpdatePatientDTO patientDTO, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.updatePatient(patientDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAPatient(@PathVariable Long id) {
        service.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }
}
