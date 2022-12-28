package com.FormationSpringBoot.GestionProduit.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @Entity
@AllArgsConstructor @NoArgsConstructor
public class Categorie {
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	@OneToMany(mappedBy = "categorie",cascade=CascadeType.ALL)
	@JsonProperty(access=Access.WRITE_ONLY)
	private List<Produit>liste;
}
