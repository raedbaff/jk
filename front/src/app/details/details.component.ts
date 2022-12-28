import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProduitServiceService } from '../services/produit-service.service';
import { Produit } from 'src/app/models/produit';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  prod!:Produit;

  constructor(private act:ActivatedRoute, private service:ProduitServiceService) {
    
    
   }

  ngOnInit(): void {
    let id=this.act.snapshot.params["id"];
    console.log(id)
    this.service.getproductbyid(id).subscribe(data=>this.prod=data)
    
  }

}
