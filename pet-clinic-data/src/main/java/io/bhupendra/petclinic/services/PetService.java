package io.bhupendra.petclinic.services;

import io.bhupendra.petclinic.model.Pet;

import java.util.Set;

public interface PetService {


    Pet findByID(Long id);

    Pet save(Pet pet);

    Set<Pet> finaAll();
}
