package com.FormationSpringBoot.GestionProduit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FormationSpringBoot.GestionProduit.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer>{
List<Produit> findByNomContains(String mc);
}
