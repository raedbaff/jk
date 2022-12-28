package com.FormationSpringBoot.GestionProduit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.FormationSpringBoot.GestionProduit.entities.Produit;

public interface IServiceProduit {
	 void saveProduit(Produit p,MultipartFile mf) throws IOException;
	  List<Produit> getAllProducts();
	  Produit getProduct(int id);
	  List<Produit> getProductsByMC(String mc);
	  void supprimerProducts(int id) throws IOException;
	  String saveImage(MultipartFile mf ) throws IOException;
	byte[] getImage(int id) throws IOException;

	  
}
