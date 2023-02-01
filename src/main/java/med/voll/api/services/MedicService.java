package med.voll.api.services;

import med.voll.api.entities.Address;
import med.voll.api.entities.Medic;
import med.voll.api.entities.dto.address.FormToUpdateAddressDTO;
import med.voll.api.entities.dto.medic.FormMedicDTO;
import med.voll.api.entities.dto.medic.FormToUpdateMedicDTO;
import med.voll.api.entities.dto.medic.MedicDTO;
import med.voll.api.entities.dto.medic.MedicDetailedDTO;
import med.voll.api.mapper.MedicMapper;
import med.voll.api.repositories.MedicRepository;
import med.voll.api.services.exceptions.MedicNotFoundException;
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
        return repository.findAllByActiveTrue(pageable).map(page -> mapper.fromMedicToMedicDTO(page));
    }

    public MedicDTO createAMedic(FormMedicDTO medicDTO) {
        return mapper.fromMedicToMedicDTO(repository.save(mapper.fromFormMedicDTOToMedic(medicDTO)));
    }

    public MedicDetailedDTO findById(Long id) {
        return mapper.fromMedicToMedicDetailedDTO(repository.findById(id).orElseThrow(() -> new MedicNotFoundException("Not a valid value, try another one.")));
    }

    public FormToUpdateMedicDTO upgradeAMedic(FormToUpdateMedicDTO medic, Long id) {
        findById(id);
        Medic monitored = repository.getReferenceById(id);
        methodToUpdateMedic(monitored, medic);
        return mapper.fromMedicToFormMedicDTODetailed(repository.save(monitored));
    }

    private void methodToUpdateMedic(Medic monitored, FormToUpdateMedicDTO medic) {
        if (medic.getName() != null) {
            monitored.setName(medic.getName());
        }

        if (medic.getPhone() != null) {
            monitored.setPhone(medic.getPhone());
        }

        if (medic.getAge() != null) {
            monitored.setAge(medic.getAge());
        }

        monitored.setmedicAddress(updateAddress(medic.getAddress(), monitored.getmedicAddress()));
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

    public void deleteAMedic(Long id) {
        findById(id);
        var medic = repository.getReferenceById(id);
        setToInactive(medic);
    }

    void setToInactive(Medic medic) {
        medic.setActive(Boolean.FALSE);
        repository.save(medic);
    }
}
