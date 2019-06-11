package org.ibm.mscomptes;

import org.ibm.mscomptes.dao.ClientRepository;
import org.ibm.mscomptes.dao.CompteRepository;
import org.ibm.mscomptes.dao.TransactionLinker;
import org.ibm.mscomptes.entities.Client;
import org.ibm.mscomptes.entities.Compte;
import org.ibm.mscomptes.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MscomptesApplication{
    public static void main(String[] args) {
        SpringApplication.run(MscomptesApplication.class, args);
    }
}
