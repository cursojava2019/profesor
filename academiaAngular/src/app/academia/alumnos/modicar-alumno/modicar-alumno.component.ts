import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Alumno } from 'src/app/shared/entities/alumno';
import { AlumnoService } from 'src/app/shared/services/alumno.service';
import { routerTransition } from 'src/app/router.animations';

@Component({
  selector: 'app-modicar-alumno',
  templateUrl: './modicar-alumno.component.html',
  styleUrls: ['./modicar-alumno.component.scss'],
  animations: [routerTransition()]
})
export class ModicarAlumnoComponent implements OnInit {
  alumnoActual: Alumno;
  constructor(private rutaActiva: ActivatedRoute, private alumnoService: AlumnoService, private router: Router) {


  }

  ngOnInit() {
    let id = this.rutaActiva.snapshot.params.idAlumno;
    this.alumnoActual = this.alumnoService.findById(id);
    console.log(this.alumnoActual);
  }

  modificar(a: Alumno){
    this.alumnoService.modificar(a);
    this.router.navigate(['alumnos']);
  }

}
