import { NgModule, ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Pagina1Component } from './pagina1/pagina1.component';
import { Pagina2Component } from './pagina2/pagina2.component';

const routes: Routes = [


    { path: '', component: Pagina1Component },
    { path: 'pagina2', component: Pagina2Component },

];


export const routing: ModuleWithProviders = RouterModule.forChild(routes);

export class Seccion1RoutingModule { }
