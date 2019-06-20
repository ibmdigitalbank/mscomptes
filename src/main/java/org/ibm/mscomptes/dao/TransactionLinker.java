package org.ibm.mscomptes.dao;


import org.ibm.mscomptes.entities.Transaction;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class TransactionLinker {

    String hostTransactions="http://mstransactions:8080";
    RestTemplate restTemplate = new RestTemplate();

    public Object get(String url){
        System.out.println("> GET REQUEST TO '"+hostTransactions+url+"'");
    return restTemplate.getForObject(hostTransactions+url, String.class);
    }
    public Transaction post(String url, Transaction t){
        System.out.println("> POST REQUEST TO '"+hostTransactions+url+"' with data : "+t.toString());
        HttpEntity<Transaction> request = new HttpEntity<>(t);
        return restTemplate.postForObject(hostTransactions+ url, request,Transaction.class);
    }
    public Object getTransactionsByCompte(Long rib){
        return get("/parcompte/"+rib.toString());
    }
    public Double getSoldByCompte(Long rib){
        return Double.parseDouble( get("/sold/"+rib.toString()).toString());
    }
    public Transaction create(Transaction t){
        return post("/transaction",t);
    }

}
