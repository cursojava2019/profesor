import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-pagina1',
  templateUrl: './pagina1.component.html',
  styleUrls: ['./pagina1.component.css']
})
export class Pagina1Component implements OnInit {

  constructor(private  router: Router){}

  ngOnInit() {
  }
  viajarPagina2() {
    this.router.navigate(['pagina2']);

  }
}
