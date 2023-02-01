package med.voll.api.entities.dto.patient;

import med.voll.api.entities.dto.address.FormToUpdateAddressDTO;

public class FormUpdatePatientDTO {

    private String name;
    private String phone;
    private FormToUpdateAddressDTO address;

    public FormUpdatePatientDTO() {
    }

    public FormUpdatePatientDTO(String name, String phone, FormToUpdateAddressDTO address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
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

    public FormToUpdateAddressDTO getAddress() {
        return address;
    }

    public void setAddress(FormToUpdateAddressDTO address) {
        this.address = address;
    }
}
