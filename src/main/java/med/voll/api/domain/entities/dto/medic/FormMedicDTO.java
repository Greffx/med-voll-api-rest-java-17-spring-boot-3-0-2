package med.voll.api.domain.entities.dto.medic;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.entities.dto.address.FormAddressDTO;
import med.voll.api.domain.entities.enums.MedicSpeciality;

public class FormMedicDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @JsonProperty("CRM")
    @Pattern(regexp = "\\d{4,6}", message = "must be bigger or equal than 4 and less or equal than 6") //\d it means that's a digit min and max
    private String crm;

    @Email
    @NotBlank(message = "this field can not be empty")
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private Integer age;

    @NotNull(message = "your speciality can't be empty")
    private MedicSpeciality speciality;

    @NotNull
    @Valid
    private FormAddressDTO address;

    public FormMedicDTO() {
    }

    public FormMedicDTO(Long id, String name, String crm, String email, String phone, Integer age, MedicSpeciality speciality, FormAddressDTO address) {
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

    public FormAddressDTO getAddress() {
        return address;
    }

    public void setAddress(FormAddressDTO address) {
        this.address = address;
    }
}
