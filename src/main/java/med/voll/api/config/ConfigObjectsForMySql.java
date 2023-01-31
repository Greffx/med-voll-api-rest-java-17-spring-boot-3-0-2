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

import java.util.Arrays;

@Configuration
@Profile("mySqlWorkbench")
public class ConfigObjectsForMySql {

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Bean
    public void ObjectsForTests() {

//        medicRepository.deleteAll();
//        addressRepository.deleteAll();

        Address address = new Address(null, "1th Street", 915, "near that cool market", "Porto Alegre", "RS", 91260370, "Deodoro Street");
        Address address1 = new Address(null, "2th Street", 951, "near that cool church", "São Paulo", "SP", 91264671, "Cabral Street");
        Address address2 = new Address(null, "3th Street", 195, "near that cool park", "Rio de Janeiro", "RJ", 92367370, "Pedro Street");
        Address address3 = new Address(null, "4th Street", 925, "near that cool house", "Texas", "TX", 91560270, "Donald's Street");
        Address address4 = new Address(null, "5th Street", 124, "near that cool shop", "France", "SZ", 31565770, "Petreka's Street");


        Medic medic = new Medic(null, "Eduardo", 23, "12342", "eduardo@gmail.com", "51993631620", MedicSpeciality.DERMATOLOGIST, Boolean.TRUE, address);
        Medic medic1 = new Medic(null, "Pedro", 35, "1234", "pedro@gmail.com", "41993631620", MedicSpeciality.CARDIOLOGIST, Boolean.TRUE, address1);
        Medic medic2 = new Medic(null, "Jonas", 45, "12345", "jonas@gmail.com", "71993631620", MedicSpeciality.GYNECOLOGIST, Boolean.TRUE, address2);
        Medic medic3 = new Medic(null, "Gabriel", 29,  "123456", "gabriel@gmail.com", "11993631620", MedicSpeciality.ORTHOPEDIST, Boolean.TRUE, address3);
        Medic medic4 = new Medic(null, "Alex", 38, "32145", "alex@gmail.com", "51993631620", MedicSpeciality.DERMATOLOGIST, Boolean.TRUE, address4);

        medicRepository.saveAll(Arrays.asList(medic, medic1, medic2, medic3, medic4));
        addressRepository.saveAll(Arrays.asList(address, address1, address2, address3, address4));
    }
}
