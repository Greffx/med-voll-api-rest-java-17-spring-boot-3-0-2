package med.voll.api.entities.dto;

import med.voll.api.entities.Address;
import med.voll.api.entities.enums.MedicSpeciality;

public class FormToUpdateMedicDTO {

    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private MedicSpeciality speciality;
    private FormToUpdateAddressDTO address;

    public FormToUpdateMedicDTO() {
    }

    public FormToUpdateMedicDTO(Long id, String name, Integer age, String phone, MedicSpeciality speciality, FormToUpdateAddressDTO address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.speciality = speciality;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MedicSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(MedicSpeciality speciality) {
        this.speciality = speciality;
    }

    public FormToUpdateAddressDTO getAddress() {
        return address;
    }

    public void setAddress(FormToUpdateAddressDTO AddressDTO) {
        this.address = AddressDTO;
    }
}
