package org.ibm.mscomptes.dao;


import org.ibm.mscomptes.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@Repository
public interface CompteRepository extends JpaRepository<Compte,Double> {
    @RestResource(path = "/active")
    public List<Compte> findByEtatIsTrue();
    @RestResource(path = "/parclient")
    public List<Compte> findByClientEquals(Long id);
    @RestResource(path = "/activeparclient")
    public List<Compte> findByClientEqualsAndEtatIsTrue(Long id);
}
