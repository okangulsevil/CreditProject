package tr.com.okangulsevil.creditappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.okangulsevil.creditappbackend.model.Credit;

public interface CreditRepository extends JpaRepository<Credit, Long> {

}
