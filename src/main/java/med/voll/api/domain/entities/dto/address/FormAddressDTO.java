package med.voll.api.domain.entities.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.entities.dto.medic.MedicDetailedDTO;
import med.voll.api.domain.entities.dto.patient.FormPatientDTO;

public class FormAddressDTO {

    private Long id;

    @NotBlank(message = "must not be blank.")
    private String lougradouro;

    @NotNull(message = "number must not be blank.")
    private Integer number;

    @NotBlank(message = "complement must not be blank.")
    private String complement;

    @NotBlank(message = "city must not be blank.")
    private String city;

    @NotBlank(message = "UF must not be blank.")
    private String UF;

    @NotNull(message = "CEP must not be blank.")
    private Integer CEP;

    @NotBlank(message = "district must not be blank.")
    private String district;

    private MedicDetailedDTO medicDTO;

    private FormPatientDTO patientDTO;

    public FormAddressDTO() {
    }

    public FormAddressDTO(Long id, String lougradouro, Integer number, String complement, String city, String UF, Integer CEP, String district) {
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
        return medicDTO;
    }

    public void setMedic(MedicDetailedDTO medic) {
        this.medicDTO = medic;
    }

    public FormPatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(FormPatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }
}
