package com.FormationSpringBoot.GestionProduit.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.FormationSpringBoot.GestionProduit.entities.Produit;
import com.FormationSpringBoot.GestionProduit.service.IServiceProduit;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin("*")

@RestController
@RequestMapping("/restapiproduit")
public class ProduitRestController {
	@Autowired IServiceProduit sp;
@GetMapping("/all")
public List<Produit>getAllProducts(){
	return sp.getAllProducts();
}
@GetMapping("/get/{id}")
public  Produit getProductsid(@PathVariable("id") Integer id){
	return sp.getProduct(id);
}
@GetMapping("/chercherbyMC/{mc}")
public List<Produit>getProducts(@PathVariable("mc") String mot){
	return sp.getProductsByMC(mot);
}
@GetMapping(path="/getImage/{id}", produces=MediaType.IMAGE_JPEG_VALUE)
public byte[] getImage(@PathVariable("id") int id) throws IOException {
	return sp.getImage(id);
}
@PostMapping("/add")
public void saveProduct(@RequestParam("produit") String p,@RequestParam("file") MultipartFile mf) throws IOException {
	Produit pp=new ObjectMapper().readValue(p,Produit.class);
	sp.saveProduit(pp, mf);
}
@DeleteMapping("/Delete/{id}")
public void DeleteProduit(@PathVariable int id) throws IOException{
	sp.supprimerProducts(id);
}
@PutMapping("/update")
public void update(@RequestParam("produit") String p,@RequestParam("file") MultipartFile mf) throws IOException {
	saveProduct(p,mf);
}


}
