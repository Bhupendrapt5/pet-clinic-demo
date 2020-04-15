package io.bhupendra.petclinic.services.map;

import io.bhupendra.petclinic.model.Speciality;
import io.bhupendra.petclinic.model.Vet;
import io.bhupendra.petclinic.services.SpecialityService;
import io.bhupendra.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialties().size()>=0){
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId()==null){
                    Speciality savedSpecialty = specialityService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });

        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
