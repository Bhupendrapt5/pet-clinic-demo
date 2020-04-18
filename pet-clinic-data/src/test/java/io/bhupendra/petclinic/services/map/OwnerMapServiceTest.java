package io.bhupendra.petclinic.services.map;

import io.bhupendra.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Kent";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetrMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());

    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner  obj = Owner.builder().id(id).build();
        Owner saveOwner = ownerMapService.save(obj);

        assertEquals(id, saveOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner saveOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());

    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0 , ownerMapService.findAll().size());

    }

    @Test
    void delete() {

        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0 , ownerMapService.findAll().size());

    }

    @Test
    void findByLastName() {
        Owner kent =ownerMapService.findByLastName(lastName);

//        assertEquals(ownerId, kent.getId());
//        assertEquals(lastName,kent.getLastName());
        assertNotNull(kent);
    }

    @Test
    void findByLastNameNotFound() {
        Owner kent =ownerMapService.findByLastName("dummy");
;
        assertNull(kent);
    }
}