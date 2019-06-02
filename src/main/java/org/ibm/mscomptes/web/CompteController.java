package org.ibm.mscomptes.web;

import org.ibm.mscomptes.dao.CompteRepository;
import org.ibm.mscomptes.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteController {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping("/comptes")
    public List<Compte> getComptes(){
        return compteRepository.findAll();
    }
    @GetMapping("/comptes/{rib}")
    public Compte getCompte(@PathVariable Double rib){
        return compteRepository.getOne(rib);
    }
    @PostMapping("/compte")
    public void newOne(@RequestBody Compte c){
        compteRepository.save(c);
    }
    @PatchMapping("/compte")
    public void saveCompte(@PathVariable Double rib,@RequestBody Compte c){
        compteRepository.save(c);
    }



}
