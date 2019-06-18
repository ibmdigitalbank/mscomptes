package org.ibm.mscomptes.web;

import org.ibm.mscomptes.dao.CompteRepository;
import org.ibm.mscomptes.dao.TransactionLinker;
import org.ibm.mscomptes.entities.Compte;
import org.ibm.mscomptes.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;

@CrossOrigin("*")
@RestController
public class transactionsController {
    private TransactionLinker linker=new TransactionLinker();
    @Autowired
    private CompteRepository compteRepository;

    
    @GetMapping("/transactions/{rib}")
    public Object getTransactionsByCompte(@PathVariable Long rib){
        return linker.getTransactionsByCompte(rib);
    }

    @GetMapping("/sold/{rib}")
    public Double getSoldByCompte(@PathVariable Long rib){
        return linker.getSoldByCompte(rib);
    }
    @PostMapping("/transaction")
    @Transactional
    public Transaction newline(@RequestBody Transaction t){
        System.out.println("------------- new Transaction -------------");
        t.setDate(new Date());
        Compte source=compteRepository.findById(t.getSource()).get();
        Compte destination=compteRepository.findById(t.getDestination()).get();
        source.debiter(t.getMontant());
        destination.crediter(t.getMontant());
        compteRepository.save(source);
        compteRepository.save(destination);
        System.out.println("source : "+source.toString());
        System.out.println("destination : "+destination.toString());
        System.out.println("montant : "+t.getMontant());
        System.out.println("date : "+t.getDate().toString());
        System.out.println("motif : "+ t.getMotif());
        Transaction ret=linker.create(t);
        System.out.print("RESULT : ");
        if(ret!=null) System.out.print(ret.toString());
        else System.out.print("FAILED");
        return ret;
    }


}
