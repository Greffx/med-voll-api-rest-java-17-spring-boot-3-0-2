package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.entities.Patient;
import med.voll.api.entities.dto.patient.FormUpdatePatientDTO;
import med.voll.api.entities.dto.patient.TypeForListPatientDTO;
import med.voll.api.services.PatientService;
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
    public ResponseEntity<Patient> findPatientById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findByIdPatient(id));
    }

//    @PostMapping
//    public ResponseEntity<Patient> create(@RequestBody @Valid PatientDTO patient, UriComponentsBuilder builder) {
//        return ResponseEntity.created(builder.path("patient/{id}").buildAndExpand(patient.getId()).toUri()).body(service.createAPatient(patient));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody FormUpdatePatientDTO patientDTO, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.updatePatient(patientDTO, id));
    }
}
