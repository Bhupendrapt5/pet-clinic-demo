package io.bhupendra.petclinic.bootstrap;

import io.bhupendra.petclinic.model.Owner;
import io.bhupendra.petclinic.model.Vet;
import io.bhupendra.petclinic.services.OwnerService;
import io.bhupendra.petclinic.services.VetService;
import io.bhupendra.petclinic.services.map.OwnerServiceMap;
import io.bhupendra.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitializer() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Abhi");
        owner1.setLastName("Gupta");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Bruce");
        owner2.setLastName("Wayne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Dumb");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Alex");
        vet2.setLastName("Musk");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
