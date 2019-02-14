import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Task } from '../model/task';


@Component({
  selector: 'app-tarea',
  templateUrl: './tarea.component.html',
  styleUrls: ['./tarea.component.css']
})
export class TareaComponent implements OnInit {

  @Input()
  tarea: Task;

  @Input()
  indice;

  @Output()
   evento = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  eliminar() {
    this.evento.emit(this.indice);
    console.log('Evento ' + this.indice);
  }

}
