package org.ibm.mscomptes.web;

import org.ibm.mscomptes.dao.CompteRepository;
import org.ibm.mscomptes.dao.TransactionLink;
import org.ibm.mscomptes.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
public class CompteController {
    @Autowired
    private CompteRepository compteRepository;
    TransactionLink transactionLink=new TransactionLink();
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
    @PostMapping("/compte")
    public void newOne(@RequestBody Compte c){
        compteRepository.save(c);
    }

    @PatchMapping("/compte")
    public void saveCompte(@PathVariable Double rib,@RequestBody Compte c){
        compteRepository.save(c);
    }



    @GetMapping("/transactions")
    public Object getTransactions(){
        return transactionLink.getTransactions();
    }
    @GetMapping("/transactions/{rib}")
    public Object getTransactionsByCompte(@PathVariable Long rib){
        return transactionLink.getTransactionsByCompte(rib);
    }
    @GetMapping("/sold/{rib}")
    public Double getSoldByCompte(@PathVariable Long rib){
        return transactionLink.getSoldByCompte(rib);
    }

}
