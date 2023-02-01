package med.voll.api.domain.entities.dto.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.entities.dto.address.FormAddressDTO;

public class FormPatientDTO {

    private Long id;

    @NotBlank
    private String name;
    private Integer age;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String cpf;

    @Valid
    @NotNull
    private FormAddressDTO address;

    public FormPatientDTO() {
    }

    public FormPatientDTO(Long id, String name, Integer age, String email, String phone, String cpf, Boolean active, FormAddressDTO address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public FormAddressDTO getPatientAddress() {
        return address;
    }

    public void setPatientAddress(FormAddressDTO patientAddress) {
        this.address = patientAddress;
    }

}
