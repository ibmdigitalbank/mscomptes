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
public class MscomptesApplication /*implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(MscomptesApplication.class, args);
    }
    /*
    @Autowired
    private ClientRepository clientRep;
    @Autowired
    private CompteRepository compteRep;
    TransactionLinker transactionLinker;

    @Override
    public void run(String... args) throws Exception {

        Client cl1=new Client(null,"A123456","Oumaima","BOUJADI",new Date("27/12/1997"),"marocaine","celibataire","sans","Oumaima@exemple.com","0612349876","0504050607","ma","casablanca","boulevard hassan2, Num 487");
        Client cl2=new Client(null,"B842657","Hassan","AMRANI",new Date("27/01/1991"),"marocaine","marie","architect","Hassan@exemple.com","0697316482","0504050609","ma","casablanca","boulevard hassan2, Num 487");
        cl1=clientRep.save(cl1);
        cl2=clientRep.save(cl2);
        Compte c1=new Compte( Double.parseDouble("12123456789002"),cl1.getId(),"courant",true, (double) 0,new Date("01/01/2019"));
        Compte c2=new Compte( Double.parseDouble("12123456789001"),cl1.getId(),"epargne",true, (double) 0,new Date("01/01/2019"));
        Compte c3=new Compte( Double.parseDouble("12123456789540"),cl1.getId(),"individuel",false, (double) 0,new Date("05/05/2019"));
        c1=compteRep.save(c1);
        c2=compteRep.save(c2);
        c3=compteRep.save(c3);
        Compte c4=new Compte( Double.parseDouble("12123456790002"),cl2.getId(),"courant",true, (double) 0,new Date("01/01/2019"));
        c4=compteRep.save(c4);

        transactionLinker=new TransactionLinker();
        Transaction t1=new Transaction(null,c1.getRIB(),c2.getRIB(),new Date(),(double)1587,"virement");
        Transaction t2=new Transaction(null,c1.getRIB(),c3.getRIB(),new Date(),(double)10000,"virement");
        Transaction t3=new Transaction(null,c1.getRIB(),c4.getRIB(),new Date(),(double)2000,"logement");
        Transaction t4=new Transaction(null,c4.getRIB(),c1.getRIB(),new Date(),(double)100000,"loan");
        Transaction t5=new Transaction(null,c2.getRIB(),c4.getRIB(),new Date(),(double)6500,"loan");
        Transaction t6=new Transaction(null,c2.getRIB(),c1.getRIB(),new Date(),(double)2050,"virement");
        Transaction t7=new Transaction(null,c4.getRIB(),c2.getRIB(),new Date(),(double)80000,"eparge");
        transactionLinker.create(t1);
        transactionLinker.create(t2);
        transactionLinker.create(t3);
        transactionLinker.create(t4);
        transactionLinker.create(t5);
        transactionLinker.create(t6);
        transactionLinker.create(t7);



    }
     */
}
