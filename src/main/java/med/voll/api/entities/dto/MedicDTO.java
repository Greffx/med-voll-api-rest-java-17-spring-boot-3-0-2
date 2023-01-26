package med.voll.api.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.entities.Address;
import med.voll.api.entities.enums.MedicSpeciality;
import org.hibernate.validator.constraints.Length;

@JsonPropertyOrder({"id", "crm", "email", "phone", "speciality", "address"})
public class MedicDTO {

    private Long id;

    @JsonProperty("CRM")
    @Pattern(regexp = "\\d{4,6}", message = "must be bigger or equal than 4 and less or equal than 6") //\d it means that's a digit min and max
    private String crm;

    @Email
    @NotBlank(message = "this field can not be empty")
    private String email;
    private String phone;

    @NotNull(message = "your speciality can't be empty")
    private MedicSpeciality speciality;

    @NotNull
    @Valid
    private Address address;

    public MedicDTO() {
    }

    public MedicDTO(Long id, String crm, String email, String phone, MedicSpeciality speciality, Address address) {
        this.id = id;
        this.crm = crm;
        this.email = email;
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
