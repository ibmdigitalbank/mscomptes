package org.ibm.mscomptes.web;

import org.ibm.mscomptes.dao.CompteRepository;
import org.ibm.mscomptes.dao.TransactionLinker;
import org.ibm.mscomptes.entities.Compte;
import org.ibm.mscomptes.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

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
    public Transaction newOne(@RequestBody Transaction t){

        Compte source=compteRepository.findById(t.getSource()).get();
        Compte destination=compteRepository.findById(t.getDestination()).get();
        source.debiter(t.getMontant());
        destination.crediter(t.getMontant());
        compteRepository.save(source);
        compteRepository.save(destination);

        System.out.println(String.format("--------------%s\nmotif : %s\nmontant : %d",t.getDate().toString(),t.getMotif(),t.getMontant()));
        String format="compte :%s\ttype :%s";
        System.out.println(String.format(format,source.getRIB().toString(),"OUT"));
        System.out.println(String.format(format,destination.getRIB().toString(),"OUT"));

        return linker.create(t);
    }


}
