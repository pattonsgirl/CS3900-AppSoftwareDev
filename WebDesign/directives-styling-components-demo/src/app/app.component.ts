import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {TestComponent} from "./test/test.component";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TestComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  isVisible: boolean = true;
  backgroundColor: string = 'lightblue';
  fontSize: string = '16px';
  primaryColor: string = 'blue';
  messageFromApp: string = 'Hello from App component';
  messageFromChild: string = '';

  toggleStyle() {
    this.backgroundColor = this.backgroundColor === 'lightblue' ? 'lightcoral' : 'lightblue';
    this.fontSize = this.fontSize === '16px' ? '20px' : '16px';
  }

  toggleActive() {
    this.isVisible = !this.isVisible;
  }

  toggleColor() {
    this.primaryColor = this.primaryColor === 'blue' ? 'red' : 'blue';
  }

  receiveMessage(message: string) {
    this.messageFromChild = message;
  }
}
