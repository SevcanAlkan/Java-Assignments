import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Todo } from './models/todo.mode';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http: HttpClient) {
  }

  public get(showIsDelete: boolean = false, showIsCompleted: boolean = false): Observable<any> {
    return this.http.get<Todo[]>(environment.apiUrl + '/todo');
  }

  public getById(id: number): Observable<any> {
    return this.http.get<Todo>(environment.apiUrl + `/todo/${id.toString()}`);
  }

  public post(model: Todo): Observable<any> {
    return this.http.post<Todo>(environment.apiUrl + `/todo`, model);
  }

  public put(id: number, model: Todo): Observable<any> {
    return this.http.put<Todo>(environment.apiUrl + `/todo/${id.toString()}`, model);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete<void>(environment.apiUrl + `/todo/${id.toString()}`);
  }
}
