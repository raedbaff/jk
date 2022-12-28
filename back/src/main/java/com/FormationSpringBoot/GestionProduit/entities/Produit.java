package com.FormationSpringBoot.GestionProduit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @Entity
@AllArgsConstructor @NoArgsConstructor
public class Produit {
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private double prix;
	private String photo;
	private int quantite;
	@ManyToOne
	private Categorie categorie;

}
