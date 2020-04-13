package io.bhupendra.petclinic.bootstrap;

import io.bhupendra.petclinic.model.*;
import io.bhupendra.petclinic.services.OwnerService;
import io.bhupendra.petclinic.services.PetTypeService;
import io.bhupendra.petclinic.services.SpecialityService;
import io.bhupendra.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;

        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count ==0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType turtle = new PetType();
        turtle.setName("Turtle");
        PetType savedTurtlePetType = petTypeService.save(turtle);

        System.out.println("Loaded PetTypes");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty saveRadiology = specialityService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty saveSurgery = specialityService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty saveDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Abhi");
        owner1.setLastName("Gupta");
        owner1.setAddress("123 Random Place");
        owner1.setCity("Mumbai");
        owner1.setMobile("963852741");

        Pet abiPet = new Pet();
        abiPet.setPetType(savedDogPetType);
        abiPet.setOwner(owner1);
        abiPet.setBirthDate(LocalDate.now());
        abiPet.setPetName("Kaiser");

        owner1.getPets().add(abiPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bruce");
        owner2.setLastName("Wayne");
        owner2.setAddress("253 On Hill");
        owner2.setCity("Gotham");
        owner2.setMobile("789528596");

        Pet bruPet = new Pet();
        bruPet.setPetType(savedCatPetType);
        bruPet.setOwner(owner2);
        bruPet.setBirthDate(LocalDate.now());
        bruPet.setPetName("Chonky");

        owner2.getPets().add(bruPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Dumb");
        vet1.getSpecialties().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alex");
        vet2.setLastName("Musk");
        vet2.getSpecialties().add(saveSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
