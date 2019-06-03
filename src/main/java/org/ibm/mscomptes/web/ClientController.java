package org.ibm.mscomptes.web;

import org.ibm.mscomptes.dao.ClientRepository;
import org.ibm.mscomptes.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ClientController {
    @Autowired
    private ClientRepository repository;

    @GetMapping("/clients")
    public List<Client> getAll(){
        return repository.findAll();
    }
    @GetMapping("/clients/{id}")
    public Client getOne(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @PostMapping("/clients")
    public void newOne(@RequestBody Client c){
        repository.save(c);
    }
    @PatchMapping("/clients")
    public void saveCompte(@PathVariable Double rib,@RequestBody Client c){
        repository.save(c);
    }



}
