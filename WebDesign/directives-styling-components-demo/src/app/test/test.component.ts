import {Component, EventEmitter, Input, Output,} from '@angular/core';

@Component({
  selector: 'app-test',
  standalone: true,
  imports: [],
  templateUrl: './test.component.html',
  styleUrl: './test.component.css'
})
export class TestComponent {
  @Input() message: string = '';
  @Output() messageEvent = new EventEmitter<string>;

  sendMessage() {
    this.messageEvent.emit('Hello from Test Component!')
  }
}
