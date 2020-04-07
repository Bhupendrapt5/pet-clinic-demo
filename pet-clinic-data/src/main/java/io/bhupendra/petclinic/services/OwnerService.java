package io.bhupendra.petclinic.services;

import io.bhupendra.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}