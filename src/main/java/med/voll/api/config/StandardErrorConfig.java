package med.voll.api.config;

import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class StandardErrorConfig {

    private String messageError;
    private String path;
    private Integer statusCode;
    private String typeOfError;
    private Instant momentOfError;

    public StandardErrorConfig() {
    }

    public StandardErrorConfig(String messageError, String path, Integer statusCode, String typeOfError, Instant momentOfError) {
        this.messageError = messageError;
        this.path = path;
        this.statusCode = statusCode;
        this.typeOfError = typeOfError;
        this.momentOfError = momentOfError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getTypeOfError() {
        return typeOfError;
    }

    public void setTypeOfError(String typeOfError) {
        this.typeOfError = typeOfError;
    }

    public Instant getMomentOfError() {
        return momentOfError;
    }

    public void setMomentOfError(Instant momentOfError) {
        this.momentOfError = momentOfError;
    }
}
