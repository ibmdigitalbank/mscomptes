package org.ibm.mscomptes.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ibm.mscomptes.dao.ClientRepository;
import org.ibm.mscomptes.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@Api(value="Client Controller", description="operations to manage clients")
public class ClientController {
    @Autowired
    private ClientRepository repository;

    @GetMapping("/clients")
    @ApiOperation(value = "list of all client")
    public List<Client> getAll(){
        return repository.findAll();
    }
    @GetMapping("/clients/{id}")
    @ApiOperation(value = "get a client details")
    public Client getOne(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @PostMapping("/clients")
    @ApiOperation(value = "create new client")
    public void newOne(@RequestBody Client c){
        repository.save(c);
    }
    @PutMapping("/clients")
    @ApiOperation(value = "update a client")
    public void save(@PathVariable Long id,@RequestBody Client c){
        repository.save(c);
    }



}
