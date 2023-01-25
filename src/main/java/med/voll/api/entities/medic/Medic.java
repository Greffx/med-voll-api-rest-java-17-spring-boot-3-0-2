package med.voll.api.entities.medic;


import jakarta.persistence.*;
import med.voll.api.entities.Address;
import med.voll.api.entities.medic.enums.Speciality;

@Entity
@Table(name = "tb_medic")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CRM;
    private String email;
    private String phone;
    private Speciality speciality;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Medic() {
    }

    public Medic(Long CRM, String email, String phone, Speciality speciality, Address address) {
        this.CRM = CRM;
        this.email = email;
        this.phone = phone;
        this.speciality = speciality;
        this.address = address;
    }

    public Long getCRM() {
        return CRM;
    }

    public void setCRM(Long CRM) {
        this.CRM = CRM;
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
