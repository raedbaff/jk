import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetailsComponent } from './details/details.component';
import { ListProduitComponent } from './components/list-produit/list-produit.component';




const routes: Routes = [
  {path:'all',component:ListProduitComponent},
  { path: 'all/:id', component: DetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
