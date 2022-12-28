package com.FormationSpringBoot.GestionProduit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FormationSpringBoot.GestionProduit.entities.Categorie;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {

}
