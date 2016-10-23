package com.ps.controller;

import com.ps.model.IPetRepository;
import com.ps.model.entity.Pet;
import com.ps.security.SecurityRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private IPetRepository repo;

    /**
     * Get the list of pet in the store.
     * @return The list of Pets.
     */
    @RolesAllowed({
            SecurityRole.USER_A, SecurityRole.USER_B
    })
    @RequestMapping(value = "/pet", method = RequestMethod.GET)
    List list() {
        return this.repo.findAll();
    }

    /**
     * Add a new pet in the store.
     * @param pet The pet to add.
     * @return The newly added pet.
     */
    @RolesAllowed(SecurityRole.USER_B)
    @RequestMapping(value = "/pet", method = RequestMethod.POST)
    Pet add(@RequestBody @Valid final Pet pet) {
        pet.setId(null);
        return this.repo.saveAndFlush(pet);
    }

    /**
     * Retrieve a pet based on his id.
     * @param petId The id of the pet.
     * @return The requested pet.
     */
    @RolesAllowed({
            SecurityRole.USER_A, SecurityRole.USER_B
    })
    @RequestMapping(value = "/pet/{petId}", method = RequestMethod.GET)
    Pet show(@PathVariable final Integer petId) {
        return this.repo.findOne(petId);
    }

    /**
     * Delete a pet based on his id.
     * @param petId The id of the pet to delete.
     */
    @RolesAllowed(SecurityRole.USER_B)
    @RequestMapping(value = "/pet/{petId}", method = RequestMethod.DELETE)
    void delete(@PathVariable final Integer petId) {
        this.repo.delete(petId);
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
