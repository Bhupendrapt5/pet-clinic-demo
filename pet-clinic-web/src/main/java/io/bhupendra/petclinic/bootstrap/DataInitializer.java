package io.bhupendra.petclinic.bootstrap;

import io.bhupendra.petclinic.model.Owner;
import io.bhupendra.petclinic.model.PetType;
import io.bhupendra.petclinic.model.Vet;
import io.bhupendra.petclinic.services.OwnerService;
import io.bhupendra.petclinic.services.PetTypeService;
import io.bhupendra.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;

        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType =  petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType =  petTypeService.save(cat);

        PetType turtle = new PetType();
        turtle.setName("Turtle");
        PetType savedTurtlePetType =  petTypeService.save(turtle);

        System.out.println("Loaded PetTypes");


        Owner owner1 = new Owner();
        owner1.setFirstName("Abhi");
        owner1.setLastName("Gupta");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bruce");
        owner2.setLastName("Wayne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Dumb");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alex");
        vet2.setLastName("Musk");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
