import { Component, OnInit, OnDestroy } from '@angular/core';
import { Todo } from './models/todo.mode';
import { TodoService } from './todo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {

  public items: Todo[];
  public showIsDeleted: boolean;
  public showIsCompleted: boolean;

  constructor(private todoService: TodoService) {
    this.items = [];
    this.showIsCompleted = true;
    this.showIsDeleted = false;
  }

  ngOnInit() {
    this.loadTodoItems();
  }

  ngOnDestroy() {

  }

  private loadTodoItems(): void {
    this.todoService.get(this.showIsDeleted, this.showIsCompleted).subscribe(data => {
      if (data) {
        this.items = data as Todo[];
      }
    });
  }
}
