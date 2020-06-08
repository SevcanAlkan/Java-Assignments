import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Todo } from 'src/app/models/todo.mode';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.scss']
})
export class EditItemComponent implements OnInit {

  @Input() item: Todo;

  @Output() completeEvent: EventEmitter<Todo>;

  constructor() { }

  ngOnInit() {

  }

  public submit(): void {

  }

  public cancel(): void {
    
  }
}
