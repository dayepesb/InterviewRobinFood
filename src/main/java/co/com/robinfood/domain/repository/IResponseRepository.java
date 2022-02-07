package co.com.robinfood.domain.repository;

import co.com.robinfood.domain.entity.ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResponseRepository extends JpaRepository<ResponseEntity, Long> {
}
