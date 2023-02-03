package med.voll.api.domain.entities.dto.security;

public class TokenJwtDTO {
    private String token;

    public TokenJwtDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
