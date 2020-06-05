import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'todolist';

  myTimestamp = Date.now();
  dateInLocalTimezone;
  
  date1;
  date2;

  constructor() {
    const date = new Date(this.myTimestamp.valueOf());
    const diff = new Date(this.myTimestamp.valueOf()).getTimezoneOffset();
    this.dateInLocalTimezone = date.setMinutes(diff);

    this.date1 = new Date().toUTCString();

    this.date2 = new Date(this.dateInLocalTimezone.valueOf()).toTimeString();
  }
}
