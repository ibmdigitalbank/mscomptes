package org.ibm.mscomptes.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value="Transactions Controller", description="Transactions microservices linker")
public class transactionsController {
    private TransactionLinker linker=new TransactionLinker();
    @Autowired
    private CompteRepository compteRepository;

    
    @GetMapping("/transactions/{rib}")
    @ApiOperation(value = "list of transactions of an account")
    public Object getTransactionsByCompte(@PathVariable Long rib){
        return linker.getTransactionsByCompte(rib);
    }

    @GetMapping("/sold/{rib}")
    @ApiOperation(value = "calculate sold of an account")
    public Double getSoldByCompte(@PathVariable Long rib){
        return linker.getSoldByCompte(rib);
    }
    @PostMapping("/transaction")
    @ApiOperation(value = "create a new transaction")
    @Transactional
    public Transaction newline(@RequestBody Transaction t){
        t.setDate(new Date());
        Compte source=compteRepository.findById(t.getSource()).get();
        Compte destination=compteRepository.findById(t.getDestination()).get();
        source.debiter(t.getMontant());
        destination.crediter(t.getMontant());
        compteRepository.save(source);
        compteRepository.save(destination);
        Transaction ret=linker.create(t);
        return ret;
    }


}
