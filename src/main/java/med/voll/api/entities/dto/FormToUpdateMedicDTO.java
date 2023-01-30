package med.voll.api.entities.dto;

public class FormToUpdateMedicDTO {

    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private FormToUpdateAddressDTO address;

    public FormToUpdateMedicDTO() {
    }

    public FormToUpdateMedicDTO(Long id, String name, Integer age, String phone, FormToUpdateAddressDTO address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
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

    public FormToUpdateAddressDTO getAddress() {
        return address;
    }

    public void setAddress(FormToUpdateAddressDTO AddressDTO) {
        this.address = AddressDTO;
    }
}
