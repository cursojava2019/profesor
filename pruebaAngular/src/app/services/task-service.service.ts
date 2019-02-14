import { Injectable } from '@angular/core';
import { Task } from '../model/task';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {
   private url = 'https://gestiontareas.firebaseio.com/ejercicio/tareas.json';
   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };
 private listado:Array<Task> =new Array<Task>();
  constructor(private http: HttpClient) {
}
/*
 public selectTasks$(): Observable<Task[]> {
   return this.http.get<Task[]>(this.url);
 }
 public selectTask$(TaskId: string): Observable<Task> {
   return this.http.get<Task>(this.url + TaskId);
 }
 public insertTask$(task: Task): Observable<Task> {
   return this.http.post<Task>(this.url, Task);
 }
public updateTask$(task: Task): Observable<Task> {
   return this.http.put<Task>(this.url + task.id, Task);
 }
 public deleteTask$(operation: Operation): Observable<any> {
   return this.http.delete(this.url + task.id);
 }
 */

  add(tarea: Task) {
    this.listado.push(tarea);
  }
  addSimple(nombre: string , estado: boolean) {
    let tarea = new Task( estado, nombre);
    this.listado.push(tarea);
  }
  findAll() {
    return this.listado;
  }
  deleteTarea(indice: number) {
    this.listado.splice(indice, 1);
  }
}
