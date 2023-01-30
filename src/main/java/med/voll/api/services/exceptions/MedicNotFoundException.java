package med.voll.api.services.exceptions;

public class MedicNotFoundException extends RuntimeException {
    public MedicNotFoundException(String message) {
        super(message);
    }
}
