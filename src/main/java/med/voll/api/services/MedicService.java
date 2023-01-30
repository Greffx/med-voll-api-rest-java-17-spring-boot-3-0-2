package med.voll.api.services;

import med.voll.api.entities.Address;
import med.voll.api.entities.Medic;
import med.voll.api.entities.dto.*;
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
    private MedicMapper medicMapper;

    public Page<MedicDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(page -> medicMapper.fromMedicToMedicDTO(page));
    }

    public void createAMedic(FormMedicDTO medicDTO) {
        repository.save(medicMapper.fromFormMedicDTOToMedic(medicDTO));
    }

    public MedicDTO findById(Long id) {
        return medicMapper.fromMedicToMedicDTO(repository.findById(id).orElseThrow(() -> new MedicNotFoundException("Not a valid value, try another one.")));
    }

    public void upgradeAMedic(FormToUpdateMedicDTO medic, Long id) {
        findById(id);
        Medic monitored = repository.getReferenceById(id);
        methodToUpdateMedic(monitored, medic);
        repository.save(monitored);
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

        monitored.setAddress(updateAddress(medic.getAddress(), monitored.getAddress()));
    }

    private Address updateAddress(FormToUpdateAddressDTO addressDTO, Address address) {
        if (addressDTO.getCEP() != null) {
            address.setCEP(addressDTO.getCEP());
        }

        if (addressDTO.getCity() != null) {
            address.setCity(addressDTO.getCity());
        }

        if (addressDTO.getComplement() != null) {
            address.setComplement(addressDTO.getComplement());
        }

        if (addressDTO.getDistrict() != null) {
            address.setDistrict(addressDTO.getDistrict());
        }

        if (addressDTO.getLougradouro() != null) {
            address.setLougradouro(addressDTO.getLougradouro());
        }

        if (addressDTO.getNumber() != null) {
            address.setNumber(addressDTO.getNumber());
        }

        if (addressDTO.getUF() != null) {
            address.setUF(addressDTO.getUF());
        }
        return address;
    }

    public void deleteAMedic(Long id) {
        repository.deleteById(id);
    }
}
