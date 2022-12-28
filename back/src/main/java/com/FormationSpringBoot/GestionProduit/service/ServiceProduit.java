package com.FormationSpringBoot.GestionProduit.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.FormationSpringBoot.GestionProduit.dao.ProduitRepository;
import com.FormationSpringBoot.GestionProduit.entities.Produit;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceProduit implements IServiceProduit{
	
	ProduitRepository pr;//injection de dependeance
	@Override
	public void saveProduit(Produit p, MultipartFile mf) throws IOException {
		String Photo;
		if(!mf.getOriginalFilename().equals("")) {
			Photo=saveImage(mf);
			p.setPhoto(Photo);
		}
			pr.save(p);
			
	}

	@Override
	public List<Produit> getAllProducts() {
		
		return pr.findAll();
	}

	@Override
	public Produit getProduct(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public List<Produit> getProductsByMC(String mc) {
		// TODO Auto-generated method stub
		return pr.findByNomContains(mc); 
	}

	@Override
	public void supprimerProducts(int id) throws IOException {
			if (!pr.getById(id).getPhoto().equals("")) {
				DeleteImage(id);
			}
			pr.deleteById(id);
	}

	@Override
	public String saveImage(MultipartFile mf) throws IOException {
		// TODO Auto-generated method stub
		String nameFile=mf.getOriginalFilename();
		String tab[]=nameFile.split("\\.");
		String fileModif=tab[0]+"_"+System.currentTimeMillis()+"."+tab[1];
		String chemin=System.getProperty("user.dir")+"/src/main/webapp/imagesdata/";
		Path p=Paths.get(chemin,fileModif);
		Files.write(p, mf.getBytes());
		return fileModif;
		
	}
	public void DeleteImage(Integer idProduit) throws IOException{
		Produit produit=pr.getById(idProduit);
		String chemin=System.getProperty("user.dir")+"/src/main/webapp/imagesdata/";
		Path p=Paths.get(chemin,produit.getPhoto());
		Files.delete(p);
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		String monImage=pr.findById(id).get().getPhoto()	;
		Path p=Paths.get(System.getProperty("user.home")+"/images2022/",monImage);
		return Files.readAllBytes(p);
	}

}
