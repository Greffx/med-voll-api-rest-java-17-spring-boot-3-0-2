package med.voll.api.services;

import med.voll.api.entities.Medic;
import med.voll.api.entities.dto.MedicDTO;
import med.voll.api.mapper.MedicMapper;
import med.voll.api.repositories.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicService {

    @Autowired
    private MedicRepository repository;

    @Autowired
    private MedicMapper mapper;

    public List<MedicDTO> findAll() {
        return mapper.fromMedicsToListOfMedicDTO(repository.findAll());
    }

    public void createAMedic(MedicDTO medicDTO) {
        repository.save(mapper.fromMedicDTOToMedic(medicDTO));
    }
}
