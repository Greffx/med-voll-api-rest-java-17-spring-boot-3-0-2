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

    private String crm;
    private String email;
    private String phone;

    //@Enumerated(EnumType.STRING)
    private MedicSpeciality speciality;
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Medic() {
    }

    public Medic(Long id, String CRM, String email, String phone, MedicSpeciality speciality, Address address) {
        this.id = id;
        this.crm = CRM;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
