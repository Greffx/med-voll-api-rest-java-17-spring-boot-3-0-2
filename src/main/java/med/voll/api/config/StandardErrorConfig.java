package med.voll.api.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class StandardErrorConfig {

    private String message;
    private String path;
    private Integer status;

    @JsonProperty("type")
    private String typeError;
    private Instant moment;
    private String field;

    public StandardErrorConfig() {
    }

    public StandardErrorConfig(String messageError, String path, Integer statusCode, String typeOfError, Instant momentOfError) {
        this.message = messageError;
        this.path = path;
        this.status = statusCode;
        this.typeError = typeOfError;
        this.moment = momentOfError;
    }

    public StandardErrorConfig(String messageError, String path, String typeOfError, Instant momentOfError, String fieldOfError) {
        this.message = messageError;
        this.path = path;
        this.typeError = typeOfError;
        this.moment = momentOfError;
        this.field = fieldOfError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTypeError() {
        return typeError;
    }

    public void setTypeError(String typeError) {
        this.typeError = typeError;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
