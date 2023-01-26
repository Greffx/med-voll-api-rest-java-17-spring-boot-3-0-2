package med.voll.api.config;

import med.voll.api.entities.Address;
import med.voll.api.entities.Medic;
import med.voll.api.entities.enums.MedicSpeciality;
import med.voll.api.repositories.AddressRepository;
import med.voll.api.repositories.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mySqlWorkbench")
public class ConfigObjectsForMySql {

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Bean
    public void ObjectsForTests() {

        addressRepository.deleteAll();
        medicRepository.deleteAll();

        Address address = new Address(null, "1th Street", 95, "near that cool market", "Porto Alegre", "RS", 91260370, "Deodoro Street");
        addressRepository.save(address);

        Medic medic = new Medic(null, "eduardo@gmail.com", "51993631620", MedicSpeciality.DERMATOLOGIST, address);
        medicRepository.save(medic);
    }
}
