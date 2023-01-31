package med.voll.api.entities;

import jakarta.persistence.*;
import med.voll.api.entities.enums.MedicSpeciality;

import java.util.Objects;

@Entity
@Table(name = "tb_medic")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String crm;
    private String email;
    private String phone;

    //@Enumerated(EnumType.STRING)
    private MedicSpeciality speciality;
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "medicAddress_id")
    private Address medicAddress;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean active = true;

    public Medic() {
    }

    public Medic(Long id, String name, Integer age, String CRM, String email, String phone, MedicSpeciality speciality, Boolean active, Address medicAddress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.crm = CRM;
        this.email = email;
        this.phone = phone;
        this.speciality = speciality;
        this.active = active;
        this.medicAddress = medicAddress;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
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

    public Address getmedicAddress() {
        return medicAddress;
    }

    public void setmedicAddress(Address medicAddress) {
        this.medicAddress = medicAddress;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medic medic = (Medic) o;
        return getId().equals(medic.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
