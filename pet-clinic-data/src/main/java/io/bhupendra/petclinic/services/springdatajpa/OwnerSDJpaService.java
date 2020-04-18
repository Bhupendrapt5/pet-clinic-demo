package io.bhupendra.petclinic.services.springdatajpa;

import io.bhupendra.petclinic.model.Owner;
import io.bhupendra.petclinic.repositories.OwnerRepository;
import io.bhupendra.petclinic.repositories.PetRepository;
import io.bhupendra.petclinic.repositories.PetTypeRepository;
import io.bhupendra.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository,
                             PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> ownerSet = new HashSet<>();
                ownerRepository.findAll().forEach(ownerSet::add);

        return ownerSet;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong) ;
        return optionalOwner.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        System.out.println("###############%%%%%%$$$$$$$$$$$$$$$");
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
