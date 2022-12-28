package com.FormationSpringBoot.GestionProduit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FormationSpringBoot.GestionProduit.dao.CategorieRepository;
import com.FormationSpringBoot.GestionProduit.entities.Categorie;
import com.FormationSpringBoot.GestionProduit.entities.Produit;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceCategorie implements IServiceCategorie  {
	CategorieRepository cr;
	@Override
	public void addCategorie(Categorie c) {
		// TODO Auto-generated method stub
		cr.save(c);
	}

	@Override
	public List<Categorie> allCategorie() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public List<Produit> GetProductByCategory(int idc) {
		// TODO Auto-generated method stub
		return cr.getById(idc).getListe();
	}
	

	

}
