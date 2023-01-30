package med.voll.api.services;

import med.voll.api.entities.dto.FormMedicDTO;
import med.voll.api.entities.dto.MedicDTO;
import med.voll.api.mapper.MedicMapper;
import med.voll.api.repositories.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicService {

    @Autowired
    private MedicRepository repository;

    @Autowired
    private MedicMapper mapper;

    public Page<MedicDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(page -> mapper.fromMedicToMedicDTO(page));
    }

    public void createAMedic(FormMedicDTO medicDTO) {
        repository.save(mapper.fromFormMedicDTOToMedic(medicDTO));
    }

    public MedicDTO findById(Long id) {
        return mapper.fromMedicToMedicDTO(repository.findById(id).orElseThrow());
    }
}
