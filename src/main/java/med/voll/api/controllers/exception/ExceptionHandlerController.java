package med.voll.api.controllers.exception;

import jakarta.servlet.http.HttpServletRequest;
import med.voll.api.config.StandardErrorConfig;
import med.voll.api.domain.services.exceptions.MedicNotFoundException;
import med.voll.api.domain.services.exceptions.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {MedicNotFoundException.class, PatientNotFoundException.class})
    public ResponseEntity<StandardErrorConfig> code404ExceptionHandler(HttpServletRequest request, PatientNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandardErrorConfig("Id not found", request.getRequestURI(), HttpStatus.NOT_FOUND.value(), "Bad Request", Instant.now()));
    }
}
