package com.FormationSpringBoot.GestionProduit.service;

import java.util.List;

import com.FormationSpringBoot.GestionProduit.entities.Categorie;
import com.FormationSpringBoot.GestionProduit.entities.Produit;

public interface IServiceCategorie {
public void addCategorie(Categorie c);
public List<Categorie> allCategorie();
public List<Produit>GetProductByCategory(int idc);
}
