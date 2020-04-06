package io.bhupendra.petclinic.services;

import io.bhupendra.petclinic.model.Vet;

import java.util.Set;

public interface VetService {


    Vet findByID(Long id);

    Vet save(Vet vet);

    Set<Vet> finaAll();
}
