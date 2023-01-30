package med.voll.api.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.entities.Address;
import med.voll.api.entities.enums.MedicSpeciality;

@JsonPropertyOrder({"name", "email", "crm", "speciality"})
public class MedicDTO {

    @NotBlank
    private String name;

    @JsonProperty("CRM")
    @Pattern(regexp = "\\d{4,6}", message = "must be bigger or equal than 4 and less or equal than 6") //\d it means that's a digit min and max
    private String crm;

    @Email
    @NotBlank(message = "this field can not be empty")
    private String email;

    @NotNull(message = "your speciality can't be empty")
    private MedicSpeciality speciality;

    public MedicDTO() {
    }

    public MedicDTO(String name, String crm, String email, MedicSpeciality speciality, Address address) {
        this.name = name;
        this.crm = crm;
        this.email = email;
        this.speciality = speciality;
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

    public MedicSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(MedicSpeciality speciality) {
        this.speciality = speciality;
    }
}
