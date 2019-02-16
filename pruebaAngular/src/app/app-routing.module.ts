import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MiComponenteComponent } from './mi-componente/mi-componente.component';
import { Micomponente2Component } from './micomponente2/micomponente2.component';
import { GestorTareasComponent } from './gestor-tareas/gestor-tareas.component';
import { Seccion1Module } from './seccion1/seccion1.module';

const routes: Routes = [
  { path: '', component: MiComponenteComponent, },
  { path: 'path2', component: Micomponente2Component },
  { path: 'path3', component: GestorTareasComponent },
  { path: 'path5', component: GestorTareasComponent },
  { path: 'path4', loadChildren: './seccion1/seccion1.module#Seccion1Module'  },
  { path: '**', component: MiComponenteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
