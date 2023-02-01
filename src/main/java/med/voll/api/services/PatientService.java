package med.voll.api.services;

import med.voll.api.entities.Patient;
import med.voll.api.entities.dto.patient.FormUpdatePatientDTO;
import med.voll.api.entities.dto.patient.TypeForListPatientDTO;
import med.voll.api.mapper.PatientMapper;
import med.voll.api.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private PatientMapper mapper;

    public Page<TypeForListPatientDTO> findAllPatients(Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(element -> mapper.fromFormPatientDTOToPatient(element));
    }

    public Patient findByIdPatient(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Patient updatePatient(FormUpdatePatientDTO patientDTO, Long id) {
        var patient = repository.getReferenceById(id);
        methodToUpdatePatient(patient, patientDTO);
        return repository.save(patient);
    }

    private void methodToUpdatePatient(Patient patient, FormUpdatePatientDTO patientDTO) {
        if (patientDTO.getName() != null) patient.setName(patientDTO.getName());
        if (patientDTO.getPhone() != null) patient.setPhone(patientDTO.getPhone());
    }
}
