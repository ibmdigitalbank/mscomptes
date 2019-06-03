package org.ibm.mscomptes.dao;


import org.springframework.web.client.RestTemplate;

public class TransactionLink {

    String hostTransactions="http://localhost:8080";
    RestTemplate restTemplate = new RestTemplate();

    public Object get(String url){
        return restTemplate.getForObject(hostTransactions+url, String.class);
    }
    public Object getTransactions(){
        return get("/");
    }
    public Object getTransactionsByCompte(Long rib){
        return get("/parcompte/"+rib.toString());
    }
    public Double getSoldByCompte(Long rib){
        return Double.parseDouble( get("/sold/"+rib.toString()).toString());
    }
}
