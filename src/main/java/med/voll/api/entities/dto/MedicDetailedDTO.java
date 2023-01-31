package med.voll.api.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import med.voll.api.entities.enums.MedicSpeciality;

@JsonPropertyOrder({"id", "name", "crm", "age", "email", "speciality", "phone", "address"})
public class MedicDetailedDTO {

    private Long id;
    private String name;

    @JsonProperty("CRM")
    private String crm;
    private String email;
    private String phone;
    private Integer age;
    private MedicSpeciality speciality;
    private AddressDetailedDTO address;

    public MedicDetailedDTO() {
    }

    public MedicDetailedDTO(Long id, String name, String crm, String email, String phone, Integer age, MedicSpeciality speciality, AddressDetailedDTO address) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.email = email;
        this.phone = phone;
        this.age = age;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String Crm) {
        this.crm = Crm;
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

    public AddressDetailedDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDetailedDTO address) {
        this.address = address;
    }
}
