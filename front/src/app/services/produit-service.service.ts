import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';
import { Produit } from '../models/produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitServiceService {
  host="http://localhost:9090/restapiproduit"

  constructor(private client:HttpClient) { }
    public getallproducts():Observable<Produit[]>
    {
    return this.client.get<Produit[]>(this.host+"/all")
  }
  public getproductbyid(id):Observable<Produit>{
    return this.client.get<Produit>(this.host+"/get/"+id)
  }
}
