package org.ibm.mscomptes.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ibm.mscomptes.dao.CompteRepository;
import org.ibm.mscomptes.entities.Compte;
import org.ibm.mscomptes.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/transaction")
    @ApiOperation(value = "update accounts by a new transaction")
    @Transactional
    public byte newTransaction(@RequestBody Transaction t){
        Optional<Compte> source=compteRepository.findById(t.getSource());
        Optional<Compte> destination=compteRepository.findById(t.getDestination());
        if(!(source.isPresent() && destination.isPresent()))    return -1;
        if(source.get().getSold()<t.getMontant() ){
            System.out.println("SOURCE BALANCE IS NOT ENOUGH");
            return -2;
        }
        if( !(source.get().isEtat()&&destination.get().isEtat()) ){
            System.out.println("One or both accounts are not active.");
            return -3;
        }

        source.get().debiter(t.getMontant());
        destination.get().crediter(t.getMontant());
        compteRepository.save(source.get());
        compteRepository.save(destination.get());
        return 1;
    }




}
