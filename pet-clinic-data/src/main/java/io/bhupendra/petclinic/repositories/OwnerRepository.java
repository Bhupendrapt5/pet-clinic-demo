package io.bhupendra.petclinic.repositories;

import io.bhupendra.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
