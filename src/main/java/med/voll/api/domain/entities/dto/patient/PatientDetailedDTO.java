package med.voll.api.domain.entities.dto.patient;

import med.voll.api.domain.entities.Address;

public class PatientDetailedDTO {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String phone;
    private String cpf;
    private Boolean active = true;
    private Address address;

    public PatientDetailedDTO() {
    }

    public PatientDetailedDTO(Long id, String name, Integer age, String email, String phone, String cpf, Boolean active, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
        this.active = active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address patientAddress) {
        this.address = patientAddress;
    }

}
