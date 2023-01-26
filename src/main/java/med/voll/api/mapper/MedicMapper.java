package med.voll.api.mapper;

import med.voll.api.entities.Medic;
import med.voll.api.entities.dto.MedicDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicMapper {

    ModelMapper mapper = new ModelMapper();

    public MedicDTO fromMedicToMedicDTO(Medic medic) {
        return mapper.map(medic, MedicDTO.class);
    }

    public Medic fromMedicDTOToMedic(MedicDTO medic) {
        return mapper.map(medic, Medic.class);
    }

    public List<MedicDTO> fromMedicsToListOfMedicDTO(List<Medic> medic) {
        return medic.stream().map(this::fromMedicToMedicDTO).toList();
    }

}
