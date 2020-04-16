package io.bhupendra.petclinic.bootstrap;

import io.bhupendra.petclinic.model.*;
import io.bhupendra.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                           SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;

        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        //Adding Pet
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        //Adding Pet
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        //Adding Pet
        PetType turtle = new PetType();
        turtle.setName("Turtle");
        PetType savedTurtlePetType = petTypeService.save(turtle);

        System.out.println("Loaded PetTypes");

        //Adding Speciality
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialityService.save(radiology);

        //Adding Speciality
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialityService.save(surgery);

        //Adding Speciality
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry = specialityService.save(dentistry);

        //Adding Owner
        Owner owner1 = new Owner();
        owner1.setFirstName("Abhi");
        owner1.setLastName("Gupta");
        owner1.setAddress("123 Random Place");
        owner1.setCity("Mumbai");
        owner1.setMobile("963852741");

        //Adding Owner Pet
        Pet abiPet = new Pet();
        abiPet.setPetType(savedDogPetType);
        abiPet.setOwner(owner1);
        abiPet.setBirthDate(LocalDate.now());
        abiPet.setPetName("Kaiser");

        owner1.getPets().add(abiPet);

        ownerService.save(owner1);

        //Adding Owner
        Owner owner2 = new Owner();
        owner2.setFirstName("Bruce");
        owner2.setLastName("Wayne");
        owner2.setAddress("253 On Hill");
        owner2.setCity("Gotham");
        owner2.setMobile("789528596");

        //Adding Owner Pet
        Pet bruPet = new Pet();
        bruPet.setPetType(savedCatPetType);
        bruPet.setOwner(owner2);
        bruPet.setBirthDate(LocalDate.now());
        bruPet.setPetName("Chonky");

        owner2.getPets().add(bruPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        //Adding Visit
        Visit catVisit = new Visit();
        catVisit.setPet(bruPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Visit....");

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
