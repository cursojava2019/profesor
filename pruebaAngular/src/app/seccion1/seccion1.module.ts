import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Seccion1RoutingModule } from './seccion1-routing.module';
import { Pagina1Component } from './pagina1/pagina1.component';
import { Pagina2Component } from './pagina2/pagina2.component';
import { Submenu1Component } from './submenu1/submenu1.component';

@NgModule({
  declarations: [Pagina1Component, Pagina2Component, Submenu1Component],
    imports: [
    CommonModule,
    Seccion1RoutingModule
  ]
})
export class Seccion1Module { }
