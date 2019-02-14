import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';

@Component({
  selector: 'app-tasklist-component',
  templateUrl: './tasklist-component.component.html',
  styleUrls: ['./tasklist-component.component.css']
})
export class TasklistComponentComponent implements OnInit {

  listado: Array<Task>;
  tareaEntrada: string;

  constructor() {
    this.listado = new Array<Task>();
  }
    ngOnInit() {
    }

    crearTarea() {
      console.log( 'Entrada crear Tarea' );
      if ( this.tareaEntrada !== '' ) {
        const tarea: Task = new Task(false , this.tareaEntrada);
        this.listado.push(tarea);
        console.log(tarea);
        this.tareaEntrada = '';
      }
    }
   eliminar(indice: number ) {
      console.log( 'Gestor ' + indice);
      this.listado.splice(indice, 1 );

   }
}
