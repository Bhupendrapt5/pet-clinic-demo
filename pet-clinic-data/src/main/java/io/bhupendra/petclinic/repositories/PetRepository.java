package io.bhupendra.petclinic.repositories;

import io.bhupendra.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
