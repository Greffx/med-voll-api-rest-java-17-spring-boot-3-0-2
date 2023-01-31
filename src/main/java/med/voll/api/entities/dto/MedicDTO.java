package med.voll.api.entities.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import med.voll.api.entities.enums.MedicSpeciality;

@JsonPropertyOrder({"id", "name", "email", "crm", "speciality"})
public class MedicDTO {

    private Long id;
    private String name;
    private String crm;
    private String email;
    private Integer age;
    private MedicSpeciality speciality;

    public MedicDTO() {
    }

    public MedicDTO(Long id, String name, String crm, String email, Integer age, MedicSpeciality speciality) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.crm = crm;
        this.email = email;
        this.speciality = speciality;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
