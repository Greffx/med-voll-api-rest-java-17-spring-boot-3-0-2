package med.voll.api.entities.dto;

import med.voll.api.entities.Address;
import med.voll.api.entities.enums.MedicSpeciality;

public class MedicDTO {

    private Long CRM;
    private String email;
    private String phone;
    private MedicSpeciality speciality;
    private Address address;

    public MedicDTO() {
    }

    public MedicDTO(Long CRM, String email, String phone, MedicSpeciality speciality, Address address) {
        this.CRM = CRM;
        this.email = email;
        this.phone = phone;
        this.speciality = speciality;
        this.address = address;
    }

    public Long getCRM() {
        return CRM;
    }

    public void setCRM(Long CRM) {
        this.CRM = CRM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MedicSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(MedicSpeciality speciality) {
        this.speciality = speciality;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
