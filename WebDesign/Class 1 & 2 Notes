### Introduction to Angular and Basic Concepts

Angular is a modern, open-source web application framework maintained by Google, primarily used to create single-page applications (SPAs). Built with TypeScript, Angular emphasizes robustness, performance, and a highly structured approach to development. Recent Angular versions have introduced **standalone components**, which simplify the application architecture by reducing the need for traditional NgModules in many cases.

### Core Concepts of Angular (Modern Approach)
1. **Components**: In Angular, components are still the main building blocks of an application. Each component includes its HTML, CSS, and TypeScript, defining the structure, style, and behavior, respectively. Standalone components can now be created without being declared in a module, making it easier to set up independent, reusable components with their own dependencies.

2. **Standalone Components**: Angular’s shift towards standalone components allows components to directly declare their dependencies without needing to be part of an NgModule. This new approach reduces boilerplate and improves flexibility, especially for modular or micro-frontend architectures. Standalone components can import Angular features, services, and other components independently, making them a powerful alternative for building smaller or more modular applications.

3. **Data Binding**: Angular provides a rich data-binding system, including:
   - **One-way data binding**: Transfers data from the component to the view.
   - **Two-way data binding**: Synchronizes data between the component and the view.
   This helps simplify interactions between the UI and the underlying data model.

4. **Directives**: Angular includes **structural directives** (like `*ngIf` and `*ngFor`) to conditionally render elements or lists and **attribute directives** (such as `ngClass` and `ngStyle`) to dynamically modify an element's appearance or behavior.

5. **Dependency Injection**: Angular's dependency injection system is integral to its architecture, allowing components and services to be loosely coupled and easily testable. With standalone components, Angular’s DI system is more streamlined since components can now declare their own providers directly.

6. **Routing**: Angular’s routing system lets developers create multi-page experiences within a SPA framework. Routes can be configured independently in standalone components, allowing components to register their own routes and simplifying route management in larger applications.

7. **Services**: Services are reusable classes that manage data or application logic independently of the UI. In Angular, services are typically injected into components, and with standalone components, services can be provided directly within the component, further reducing module dependencies.

### How Angular is Used
Angular is designed to be versatile and is well-suited for a range of applications, from small, modular components to large, enterprise-grade applications:

- **Single-Page Applications (SPAs)**: Angular’s architecture is ideal for SPAs, where the application dynamically updates the content without full page reloads. Standalone components reduce setup time and make SPAs more manageable.

- **Large-Scale Applications**: Angular’s modularity and support for standalone components make it ideal for large-scale projects. Standalone components allow development teams to break down applications into independent units, which can be developed and deployed separately, promoting scalability and maintainability.

- **Responsive and Modular Design**: Angular’s component-based structure integrates seamlessly with CSS frameworks, flexbox, and grid layouts, making it easy to create responsive and modular applications for various screen sizes.

- **Form Handling and Validation**: Angular has extensive support for forms, including reactive forms and template-driven forms. The validation capabilities simplify the handling of user inputs and ensure data integrity.

- **Optimized Performance**: With tools like Ahead-of-Time (AOT) compilation and lazy loading, Angular optimizes performance by minimizing initial load time and reducing the application’s runtime footprint. Standalone components enhance this efficiency by enabling developers to load only the necessary dependencies.

### Standalone Components vs. Traditional NgModules
In previous Angular versions, every component had to be declared within an NgModule, which often required multiple module files and more setup steps. With standalone components, developers can now bypass some of these requirements. While NgModules are still supported and useful for organizing larger applications, standalone components provide a faster and more flexible alternative, especially for simpler projects or modular designs.

This evolution makes Angular more adaptable and friendly for both beginners and experienced developers, offering a powerful combination of structure, flexibility, and performance. Standalone components provide developers with a more intuitive and modular approach to building modern web applications in Angular.

---

- **Angular Overview**
    - Introduction to Angular and its ecosystem
    - Setting up the development environment using Angular CLI

```ts
npm install -g @angular/cli
ng version
```

```ts
ng new my-app
```

- **Components and Templates**
    - Creating and understanding components
    - Basic templating and data binding (interpolation and property binding)

In Angular, a component is a building block that controls a part of the user interface.  Each component consists of three parts:

1. HTML Template: Defines what gets rendered in the browser.
2. CSS Styles: Manages the component's appearance.
3. TypeScript Class: Contains the logic and data that drives the components behavior.

How to generate a component:
```ts
ng generate component pages/home
```

---

Interpolation is the simplest form of data binding and is used to display component data in the template using `{{ }}` syntax.

```html
<h1>{{ title }}</h1>
<p>This is a simple Angular component!</p>
```
```ts
export class ExampleComponent {
  title = "Hi mom!"
}
```

Property binding is used to set the values of properties in the DOM, like HTML attributes, based on the component's data. 


Syntax:
```html
[property] = "expression"
```

Example:
```ts
export class ExampleComponent {
  imageUrl = "https://angular.io/assets/images/logos/angular/angular.png";
}
```
```html
<img [src]="imageUrl" alt="Angular Logo">
```

In this case, `[src]="imageUrl"` binds the src attribute to the `img` element to the `imageUrl` property in the component.

- **Directives**
    - Using structural directives (ngIf, ngFor)
    - Class and style binding
    - @Input & @Output

Directives in Angular are special instructions in the DOM that change the appearance, behavior, or layout of elements.  There are 2 main types of directives:

Attribute Directives: these are used to change the appearance or behavior of an element (`ngClass`, `ngStyle`)

Structural Directives: these are used to change the DOM layout by adding or removing elements (`*ngIf`, `*ngFor`).


Attribute Directives Example:

`ngClass`: allows you to dynamically add or remove CSS classes based on component properties
```ts
export class ExampleComponent {
  isActive = true;
}
```
```html
<div [ngClass]="{'active-class': isActive, 'inactive-class': !isActive}">
  This div's class changes based on isActive.
</div>
```
If `isActive` is true, the active-class is applied. If `isActive` is false, inactive-class is applied.


`ngStyle`: allows you to dynamically set inline styles based on component properties
```ts
export class ExampleComponent {
  backgroundColor = 'lightblue';
}
```
```html
<div [ngStyle]="{'background-color': backgroundColor}">
  This div has a dynamic background color.
</div>
```


Structural Directives Example:

`*ngIf`: Conditionally displays elements
```ts
isVisible: boolean = true;
```
```html
<p *ngIf="isVisible">This is displayed conditionally.</p>
```
Here, `isVisible` is a boolean in the component class. If it is `true`, the paragraph is shown; if `false`, it's hidden.


`*ngFor`: Iterates over a list to display each item
```ts
items = ['Item 1', 'Item 2', 'Item 3']
```
```html
<ul>
  <li *ngFor="let item of items">{{ item }}</li>
</ul>
```
This displays each item in items as a list element.


Class Binding: Adds or removes CSS classes based on component properties
```ts
isActive = true;
```
```html
<div [class.active]="isActive">This div is active</div>
```
If `isActive` is true, the active class is applied.

Style Binding: Applies inline styles dynamically.
```ts
primaryColor = blue;
```
```html
<p [style.color]="primaryColor">This text is blue!</p>
```


@Input: Passing data from a Parent to a Child Component
`child.component.html`
```ts
export class ChildComponent {
  @Input() message: string = '';
}
```
`parent.component.html`
```html
<app-child [message]="'Hello Mom!'"></app-child>
```


@Output: Emits data and events from Child to Parent Component
`child.component.ts`
```ts
export class ChildComponen {
  @Output() messageEvent = new EventEmitter<string>();

  sendMessage() {
    this.messageEvent.emit("Hello from Child!");
  }
}
```
`parent.component.ts`
```ts
export class ParentComponent {
  messageFromChild: string = '';

  receiveMessage(message: string) {
    this.messageFromChild = message;
  }
}
```
`parent.component.html`
```html
<app-child (messageEvent)="receiveMessage($event)"></app-child>
<p>{{ messageFromChild }}</p>
```
Here, the child emits a message event, and the parent listens to the event, allowing for interaction between the components. 


### Styling

Flexbox: a CSS layout module that provide an efficient way to align and distribute space among items in a container. It's great for creating simple, responsive layouts. 

Key properties:

`display: flex;` Activates flex layout on the container.
`flex-direction:` Determines the direction of items (row, column)
`justify-content:` Aligns items horizontally
`align-items:` Aligns items vertically

Example of a horizontal layout with flexbox:
```html
<div class="flex-container">
  <div class="box">Box 1</div>
  <div class="box">Box 2</div>
  <div class="box">Box 3</div>
</div>
```
```css
.flex-container {
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.box {
  width: 100px;
  height: 100px;
  background-color: lightblue;
  text-align: center;
  align-content: center;
}
```
This layout places 3 boxes in a row, evenly spaced across the container. If you set `flex-direction: column;`, the boxed will stack vertically.


CSS Grid: a two-dimensional layout system that lets you arrange items in rows and columns, making it suitable for complex layouts. 

Key properties:

`display: grid;` Enables grid layout on the container
`grid-template-columns` Defines columns
`grid-template-rows` Defines rows
`gap:` Sets spacing between grid items

Example of a basic grid layout
```html
<div class="grid-container">
  <div class="box">Box 1</div>
  <div class="box">Box 2</div>
  <div class="box">Box 3</div>
  <div class="box">Box 4</div>
</div>
```
```css
.grid-container {
  display: grid;
  grid-template-columns: repeat(2, 1fr);/* 2 columns w/ 1/2 space */
  gap: 10px;
}

.box {
  background-color: lightblue;
  text-align: center;
  padding: 20px;
}
```
This layout created a 2-column grid. Each `box` spans half the container's width, and gap creates space between boxes.


Response styling allows layouts to adjust automatically for various screen sizes using media queries.

Example of a responsive grid layout:
```css
.grid-container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(150ox, 1fr));
  gap: 10px; 
}
```
Here, `auto-fit` and `minmax` make the grid flexible. Each box will take a minimum of 150px width and expand to fill the available space, creating a responsive layout without `@media` queries.

Speaking of `@media` queries, we can use them to apply styles based on the screen size.

Example of a two-column layout on larger screens, and one column on smaller screens
```css
.grid-container {
  display: grid;
  grid-template-columns: 1fr;
}

@media (min-width: 600px) {
  .grid-container {
    grid-template-columns: 1fr 1fr;
  }
}
```
This layout switches to a two-column grid when the screen width is 600px or more.

Remember:
- Flexbox excels in aligning items within a row or column.
- Grid is often better for defining the overall structure of your UI.
