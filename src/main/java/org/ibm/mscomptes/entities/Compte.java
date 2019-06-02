package org.ibm.mscomptes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Compte implements Serializable {
    @Id
    private Double RIB;
    private Long client;
    private String type;
    private boolean etat=false;
    private Double Sold= (double) 0;
    private Date dateCreation;
}
