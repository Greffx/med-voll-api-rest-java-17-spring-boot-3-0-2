package med.voll.api.domain.mapper;

import med.voll.api.domain.entities.Medic;
import med.voll.api.domain.entities.dto.medic.FormMedicDTO;
import med.voll.api.domain.entities.dto.medic.FormToUpdateMedicDTO;
import med.voll.api.domain.entities.dto.medic.MedicDTO;
import med.voll.api.domain.entities.dto.medic.MedicDetailedDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MedicMapper {

    ModelMapper mapper = new ModelMapper();

    public FormToUpdateMedicDTO fromMedicToFormMedicDTODetailed(Medic medic) {
        return mapper.map(medic, FormToUpdateMedicDTO.class);
    }

    public MedicDetailedDTO fromMedicToMedicDetailedDTO(Medic medic) {
        return mapper.map(medic, MedicDetailedDTO.class);
    }

    public Medic fromFormMedicDTOToMedic(FormMedicDTO medic) {
        return mapper.map(medic, Medic.class);
    }

    public MedicDTO fromMedicToMedicDTO(Medic medic) {
        return mapper.map(medic, MedicDTO.class);
    }
}
