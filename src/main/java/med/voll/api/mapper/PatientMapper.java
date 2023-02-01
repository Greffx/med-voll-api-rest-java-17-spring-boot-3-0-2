package med.voll.api.mapper;

import med.voll.api.entities.Patient;
import med.voll.api.entities.dto.patient.TypeForListPatientDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    ModelMapper mapper = new ModelMapper();

    public TypeForListPatientDTO fromFormPatientDTOToPatient(Patient patient) {
        return mapper.map(patient, TypeForListPatientDTO.class);
    }

}
