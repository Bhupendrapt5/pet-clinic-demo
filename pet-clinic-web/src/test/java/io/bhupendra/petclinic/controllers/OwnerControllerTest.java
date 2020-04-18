package io.bhupendra.petclinic.controllers;

import io.bhupendra.petclinic.model.Owner;
import io.bhupendra.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @Mock
    Model model;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1l).build());
        owners.add(Owner.builder().id(2l).build());

        mockMvc = MockMvcBuilders.
                standaloneSetup(controller).
                build();
    }

    @Test
    void listOwner() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners"))
                //checking Http request. 200 is for success
                .andExpect(status().is(200))
                //Expecting view(index page)
                .andExpect(view().name("owners/index"))
                //Expecting model , i.e. in this owner model size is 2
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void listOwnerByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners/index"))
                //checking Http request. 200 is for success
                .andExpect(status().is(200))
                //Expecting view(index page)
                .andExpect(view().name("owners/index"))
                //Expecting model , i.e. in this owner model size is 2
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwner() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        //verifying Zero interactions of Owner Service
        verifyZeroInteractions(ownerService);
    }
}