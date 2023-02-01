package med.voll.api.domain.services;

import med.voll.api.domain.entities.Address;
import med.voll.api.domain.entities.Patient;
import med.voll.api.domain.entities.dto.address.FormToUpdateAddressDTO;
import med.voll.api.domain.entities.dto.patient.FormPatientDTO;
import med.voll.api.domain.entities.dto.patient.FormUpdatePatientDTO;
import med.voll.api.domain.entities.dto.patient.PatientDetailedDTO;
import med.voll.api.domain.entities.dto.patient.TypeForListPatientDTO;
import med.voll.api.domain.mapper.PatientMapper;
import med.voll.api.domain.services.exceptions.PatientNotFoundException;
import med.voll.api.domain.repositories.PatientRepository;
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

    public PatientDetailedDTO findByIdPatient(Long id) {
        return mapper.fromPatientToPatientDetailedDTO(repository.findById(id).orElseThrow(() -> new PatientNotFoundException("This person doesn't exist. Try another one.")));
    }

    public PatientDetailedDTO updatePatient(FormUpdatePatientDTO patientDTO, Long id) {
        var patient = repository.getReferenceById(id);
        methodToUpdatePatient(patient, patientDTO);
        return mapper.fromPatientToPatientDetailedDTO(repository.save(patient));
    }

    private void methodToUpdatePatient(Patient patient, FormUpdatePatientDTO patientDTO) {
        if (patientDTO.getName() != null) patient.setName(patientDTO.getName());
        if (patientDTO.getPhone() != null) patient.setPhone(patientDTO.getPhone());
        patient.setPatientAddress(updateAddress(patientDTO.getAddress(), patient.getPatientAddress()));
    }

    private Address updateAddress(FormToUpdateAddressDTO addressDTO, Address address) {
        if (addressDTO.getCEP() != null) address.setCEP(addressDTO.getCEP());
        if (addressDTO.getCity() != null) address.setCity(addressDTO.getCity());
        if (addressDTO.getComplement() != null) address.setComplement(addressDTO.getComplement());
        if (addressDTO.getDistrict() != null) address.setDistrict(addressDTO.getDistrict());
        if (addressDTO.getLougradouro() != null) address.setLougradouro(addressDTO.getLougradouro());
        if (addressDTO.getNumber() != null) address.setNumber(addressDTO.getNumber());
        if (addressDTO.getUF() != null) address.setUF(addressDTO.getUF());
        return address;
    }

    public void deletePatientById(Long id) {
        var patient = mapper.fromPatientDetailedDTOToPatient(findByIdPatient(id));
        setActiveToFalse(patient);
        repository.save(patient);
    }

    private void setActiveToFalse(Patient patient) {
        patient.setActive(Boolean.FALSE);
    }

    public FormPatientDTO createAPatient(FormPatientDTO patient) {
        return mapper.FromPacientToFormPatientDTO(repository.save(mapper.FromFormPatientDTOToFormPatient(patient)));
    }
}
