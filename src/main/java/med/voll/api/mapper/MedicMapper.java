package med.voll.api.mapper;

import med.voll.api.entities.Medic;
import med.voll.api.entities.dto.FormMedicDTO;
import med.voll.api.entities.dto.FormToUpdateMedicDTO;
import med.voll.api.entities.dto.MedicDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicMapper {

    ModelMapper mapper = new ModelMapper();

    public FormToUpdateMedicDTO fromMedicToFormMedicDTODetailed(Medic medic) {
        return mapper.map(medic, FormToUpdateMedicDTO.class);
    }

    public Medic fromFormMedicDTOToMedic(FormMedicDTO medic) {
        return mapper.map(medic, Medic.class);
    }

    public MedicDTO fromMedicToMedicDTO(Medic medic) {
        return mapper.map(medic, MedicDTO.class);
    }

    public List<MedicDTO> fromMedicsToListOfMedicDTO(List<Medic> medic) {
        return medic.stream().map(this::fromMedicToMedicDTO).toList();
    }

}
