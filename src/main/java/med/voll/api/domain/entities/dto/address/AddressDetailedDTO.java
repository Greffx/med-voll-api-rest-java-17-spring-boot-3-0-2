package med.voll.api.domain.entities.dto.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import med.voll.api.domain.entities.dto.medic.MedicDetailedDTO;

public class AddressDetailedDTO {

    private Long id;
    private String lougradouro;
    private Integer number;
    private String complement;
    private String city;
    private String UF;
    private Integer CEP;

    private String district;

    @JsonIgnore
    private MedicDetailedDTO medic;

    public AddressDetailedDTO() {
    }

    public AddressDetailedDTO(Long id, String lougradouro, Integer number, String complement, String city, String UF, Integer CEP, String district) {
        this.id = id;
        this.lougradouro = lougradouro;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.UF = UF;
        this.CEP = CEP;
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLougradouro() {
        return lougradouro;
    }

    public void setLougradouro(String lougradouro) {
        this.lougradouro = lougradouro;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public Integer getCEP() {
        return CEP;
    }

    public void setCEP(Integer CEP) {
        this.CEP = CEP;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public MedicDetailedDTO getMedic() {
        return medic;
    }

    public void setMedic(MedicDetailedDTO medic) {
        this.medic = medic;
    }
}

