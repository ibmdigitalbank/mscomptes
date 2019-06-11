package org.ibm.mscomptes.web;

import org.ibm.mscomptes.dao.CompteRepository;
import org.ibm.mscomptes.dao.TransactionLinker;
import org.ibm.mscomptes.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
public class CompteController {
    @Autowired
    private CompteRepository compteRepository;

    TransactionLinker transactionLinker =new TransactionLinker();

    @GetMapping("/comptes")
    public List<Compte> getComptes(){
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{rib}")
    public Compte getCompte(@PathVariable Double rib){
        return compteRepository.getOne(rib);
    }

    @GetMapping("/parclient/{id}")
    public List<Compte> getComptesByClient(@PathVariable Long id){
        return compteRepository.findByClientEquals(id);
    }

    @GetMapping("/activeparclient/{id}")
    public List<Compte> getActiveComptesByClient(@PathVariable Long id){
        return compteRepository.findByClientEqualsAndEtatIsTrue(id);
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
