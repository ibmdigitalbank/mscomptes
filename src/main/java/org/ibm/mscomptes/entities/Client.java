package org.ibm.mscomptes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(unique = true)
    protected String CIN;
    protected String nom;
    protected String prenom;
    protected Date datenaissance;
    protected String nationalite;
    protected String etatcivile;
    protected String emploi;
    //contact attributes
    protected String Email;
    protected String tel;
    protected String fix;
    protected String paye;
    protected String address;
}
