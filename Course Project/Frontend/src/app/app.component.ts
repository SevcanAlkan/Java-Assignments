import { Component, OnInit, OnDestroy } from '@angular/core';
import { catchError, retry } from 'rxjs/operators';
import { Todo } from './models/todo.mode';
import { TodoService } from './todo.service';
import { Observable } from 'rxjs/internal/Observable';
import { of } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {

  public items: Todo[];
  public showIsDeleted: boolean;
  public showIsCompleted: boolean;
  public editModeEnabled: boolean;
  public tempItem: Todo;

  constructor(private todoService: TodoService) {
    this.items = [];
    this.showIsCompleted = true;
    this.showIsDeleted = false;
    this.editModeEnabled = false;
    this.tempItem = {} as Todo;
  }

  ngOnInit() {
    this.loadTodoItems();
  }

  ngOnDestroy() {

  }

  public getItemCount(): number {
    return this.items.length;
  }

  public add(): void {
    this.tempItem = {} as Todo;
    this.editModeEnabled = true;
  }

  public edit(item: Todo): void {
    this.tempItem = item;
    this.editModeEnabled = true;
  }

  public delete(item: Todo): void {
    item.isDeleted = true;

    this.todoService.put(item.id, item)
      .pipe(catchError(err => {
        if (err) {
          console.error(err);
        }
        return of();
      }), retry(3)).subscribe(data => {
        if (data) {
          this.loadTodoItems();
        }
    });
  }

  public complete(item: Todo): void {
    item.isCompleted = true;

    this.todoService.put(item.id, item)
      .pipe(catchError(err => {
        if (err) {
          console.error(err);
        }
        return of();
      }), retry(3)).subscribe(data => {
        if (data) {
          this.loadTodoItems();
        }
    });
  }

  public completeEditing(): void {
    this.editModeEnabled = false;
    this.tempItem = {} as Todo;
    this.loadTodoItems();
  }

  private loadTodoItems(): void {
    this.todoService.get(this.showIsDeleted, this.showIsCompleted).subscribe(data => {
      if (data) {
        this.items = data as Todo[];
      }
    });
  }
}
