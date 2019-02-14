import { Injectable } from '@angular/core';
import { Task } from '../model/task';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {
  repositorio: Array<Task>;
  constructor() {
    this.repositorio = new Array<Task>();
  }

  add( task: Task ){
    this.repositorio.push(task);
  }

}
