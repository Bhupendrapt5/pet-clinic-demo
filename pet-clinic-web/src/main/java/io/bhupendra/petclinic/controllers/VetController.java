package io.bhupendra.petclinic.controllers;

import io.bhupendra.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/vets","vets.html"})
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/", "/index", "/index.html" })
    public String listVet(Model model){

        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
