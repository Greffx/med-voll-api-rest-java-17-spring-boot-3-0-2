package med.voll.api.domain.services.exceptions;

public class MedicNotFoundException extends RuntimeException {
    public MedicNotFoundException(String message) {
        super(message);
    }
}
