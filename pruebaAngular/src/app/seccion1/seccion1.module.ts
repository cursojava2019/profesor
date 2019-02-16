import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Pagina1Component } from './pagina1/pagina1.component';
import { Pagina2Component } from './pagina2/pagina2.component';
import { Submenu1Component } from './submenu1/submenu1.component';
import { Seccion1RoutingModule } from './seccion1-routing.module';



@NgModule({
  declarations: [Pagina1Component, Pagina2Component, Submenu1Component],
    imports: [
      Seccion1RoutingModule
  ]
})
export class Seccion1Module { }
