package med.voll.api.repositories;

import med.voll.api.entities.Medic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicRepository extends JpaRepository<Medic, Long> {


    Page<Medic> findAllByActiveTrue(Pageable pageable);
}
