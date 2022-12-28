import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/models/produit';
import { ProduitServiceService } from 'src/app/services/produit-service.service';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css']
})
export class ListProduitComponent implements OnInit {
  filterterm:string;
  produits!:Produit[]

  constructor(private service:ProduitServiceService) { }

  ngOnInit(): void {
    this.service.getallproducts().subscribe(data=>this.produits=data)
  }

}
