package med.voll.api.controllers.exception;

import med.voll.api.config.StandardErrorConfig;
import med.voll.api.domain.services.exceptions.MedicNotFoundException;
import med.voll.api.domain.services.exceptions.PatientNotFoundException;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {MedicNotFoundException.class, PatientNotFoundException.class})
    public ResponseEntity<StandardErrorConfig> code404ExceptionHandler(WebRequest request, MedicNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandardErrorConfig(exception.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND.value(), "Bad Request", Instant.now()));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, NotReadablePropertyException.class})
    public ResponseEntity<List<StandardErrorConfig>> code400ExceptionHandler(WebRequest request, MethodArgumentNotValidException exception) {
        List<FieldError> errorList = exception.getFieldErrors();
        List<StandardErrorConfig> errorConfigs = new ArrayList<>();
        errorList.forEach(error -> {
            errorConfigs.add(new StandardErrorConfig(error.getDefaultMessage(),
                    request.getDescription(false),
                    "Bad Request", Instant.now(), error.getField())
            );
        });
        return ResponseEntity.badRequest().body(errorConfigs);
    }
}
