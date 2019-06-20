package org.ibm.mscomptes.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ibm.mscomptes.dao.CompteRepository;
import org.ibm.mscomptes.dao.TransactionLinker;
import org.ibm.mscomptes.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@Api(value="Compte Controller", description="operations to manage account")
public class CompteController {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping("/comptes")
    @ApiOperation(value = "list of all account")
    public List<Compte> getAll(){
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{rib}")
    @ApiOperation(value = "get a account details")
    public Compte getOne(@PathVariable Double rib){
        return compteRepository.getOne(rib);
    }

    @GetMapping("/parclient/{id}")
    @ApiOperation(value = "list of account of a client by his id")
    public List<Compte> getComptesByClient(@PathVariable Long id){
        return compteRepository.findByClientEquals(id);
    }

    @GetMapping("/activeparclient/{id}")
    @ApiOperation(value = "list of active accounts of a client by his id")
    public List<Compte> getActiveComptesByClient(@PathVariable Long id){
        return compteRepository.findByClientEqualsAndEtatIsTrue(id);
    }

    @PostMapping("/compte")
    @ApiOperation(value = "create new accounts")
    public void newOne(@RequestBody Compte c){
        compteRepository.save(c);
    }
    @PutMapping("/compte")
    @ApiOperation(value = "update a accounts")
    public void saveCompte(@PathVariable Double rib,@RequestBody Compte c){
        compteRepository.save(c);
    }
    





}
