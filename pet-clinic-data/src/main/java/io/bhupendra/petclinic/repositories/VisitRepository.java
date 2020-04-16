package io.bhupendra.petclinic.repositories;

import io.bhupendra.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
