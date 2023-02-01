package med.voll.api.mapper;

import med.voll.api.entities.Patient;
import med.voll.api.entities.dto.patient.FormPatientDTO;
import med.voll.api.entities.dto.patient.PatientDetailedDTO;
import med.voll.api.entities.dto.patient.TypeForListPatientDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    ModelMapper mapper = new ModelMapper();

    public TypeForListPatientDTO fromFormPatientDTOToPatient(Patient patient) {
        return mapper.map(patient, TypeForListPatientDTO.class);
    }

    public FormPatientDTO FromPacientToFormPatientDTO(Patient patient) {
        return mapper.map(patient, FormPatientDTO.class);
    }

    public Patient FromFormPatientDTOToFormPatient(FormPatientDTO patient) {
        return mapper.map(patient, Patient.class);
    }

    public PatientDetailedDTO fromPatientToPatientDetailedDTO(Patient patient) {
        return mapper.map(patient, PatientDetailedDTO.class);
    }

    public Patient fromPatientDetailedDTOToPatient(PatientDetailedDTO patient) {
        return mapper.map(patient, Patient.class);
    }
}
