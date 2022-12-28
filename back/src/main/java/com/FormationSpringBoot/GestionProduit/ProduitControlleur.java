package com.FormationSpringBoot.GestionProduit;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.FormationSpringBoot.GestionProduit.dao.CategorieRepository;
import com.FormationSpringBoot.GestionProduit.entities.Produit;
import com.FormationSpringBoot.GestionProduit.service.IServiceCategorie;
import com.FormationSpringBoot.GestionProduit.service.IServiceProduit;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitControlleur {
	IServiceProduit sp;
	IServiceCategorie sc;
	CategorieRepository cr;

	@GetMapping("/all")
	public String listeProduit(Model m) {
		List<Produit> liste = sp.getAllProducts();
		m.addAttribute("produits", liste);
		m.addAttribute("categories", cr.findAll());
		m.addAttribute("categorie", "toutes les categories");
		return "listeProduits";
	}

	@GetMapping("/ProductParCategory")
	public String getProductsByMc(@RequestParam("categorie") int idc, Model m) {
		m.addAttribute("categories", sc.allCategorie());
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa"+idc);
		if (idc == 0) {
			//m.addAttribute("produits", sp.getAllProducts());
			return "redirect:/produit/all";
		} else {
			m.addAttribute("produits", sc.GetProductByCategory(idc));
			m.addAttribute("categorie", cr.findById(idc).get().getNom());
			return "listeProduits";
		}
	}

	@GetMapping("/produitmc")
	public String Produitmc(@RequestParam String mc, Model m) {
		List<Produit> liste = sp.getProductsByMC(mc);
		m.addAttribute("produits", liste);
		return "listeProduits";
	}

	@GetMapping("/supprimer/{id}")
	public String suprrimerProduit(@PathVariable int id) throws IOException {
		sp.supprimerProducts(id);
		return "redirect:/produit/all";
	}

	@GetMapping("/ajouterproduit")
	public String ajoutProduit(Model m) {
		m.addAttribute("categorie", sc.allCategorie());
		return "ajouterProduit";
	}

	@PostMapping("/saveproduit")
	public String saveProduit(@ModelAttribute Produit p, @RequestParam("file") MultipartFile mf, Model m)
			throws IOException {
		Integer id = p.getId();
		sp.saveProduit(p, mf);
		if (id != null) {
			return "redirect::/produit/all";
		} else {
			m.addAttribute("message", "added successfuly");
			m.addAttribute("categorie", sc.allCategorie());
			return "ajouterProduit";
		}
	}

	@GetMapping("/modifierproduit/{idp}")
	public String modifierProduit(Model m, @PathVariable("idp") int id) {
		m.addAttribute("categorie", sc.allCategorie());
		m.addAttribute("produit", sp.getProduct(id));
		return "ajouterProduit";

	}
}
