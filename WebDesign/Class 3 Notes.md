## **Services and Dependency Injection, Routing, and Lifecycle Hooks**

### **1. Services and Dependency Injection**

#### **1.1. Introduction to Services**

**Objective:**  
Understand the purpose of services in Angular and how they promote code reusability and separation of concerns.

**Content:**

- **What are Services?**
  - Services are singleton objects that provide specific functionality across the application.
  - They are used to share data, handle business logic, interact with APIs, and more.
  
- **Benefits of Using Services:**
  - **Reusability:** Share common logic across multiple components.
  - **Separation of Concerns:** Keep components focused on the view, delegating logic to services.
  - **Testability:** Simplify unit testing by isolating business logic.


---

#### **1.2. Creating and Using Services**

**Objective:**  
Learn how to create Angular services and inject them into components using dependency injection.

**Content:**

- **Generating a Service:**
  ```bash
  ng generate service user
  ```
  - This command creates `user.service.ts` and `user.service.spec.ts`.

- **Implementing the Service:**
  ```typescript
  // user.service.ts
  import { Injectable } from '@angular/core';
  import { HttpClient } from '@angular/common/http';
  import { Observable } from 'rxjs';
  import { User } from './user.model';

  @Injectable({
    providedIn: 'root'
  })
  export class UserService {
    private apiUrl = 'https://api.example.com/users';

    constructor(private http: HttpClient) { }

    getUsers(): Observable<User[]> {
      return this.http.get<User[]>(this.apiUrl);
    }

    addUser(user: User): Observable<User> {
      return this.http.post<User>(this.apiUrl, user);
    }

    // Additional CRUD methods...
  }
  ```

- **Injecting the Service into a Component:**
  ```typescript
  // user.component.ts
  import { Component, OnInit } from '@angular/core';
  import { UserService } from './user.service';
  import { User } from './user.model';

  @Component({
    selector: 'app-user',
    templateUrl: './user.component.html',
    styleUrls: ['./user.component.css']
  })
  export class UserComponent implements OnInit {
    users: User[] = [];

    constructor(private userService: UserService) { }

    ngOnInit(): void {
      this.userService.getUsers().subscribe(users => {
        this.users = users;
      });
    }
  }
  ```

- **Displaying Data in the Template:**
  ```html
  <!-- user.component.html -->
  <h2>User List</h2>
  <ul>
    <li *ngFor="let user of users">{{ user.name }}</li>
  </ul>
  ```

---

#### **1.3. Understanding Dependency Injection**

**Objective:**  
Grasp the concept of dependency injection (DI) in Angular and its role in managing service dependencies.

**Content:**

- **What is Dependency Injection?**
  - DI is a design pattern where a class requests dependencies from external sources rather than creating them itself.
  
- **How Angular Implements DI:**
  - Angular's DI framework provides dependencies to components and services automatically.
  
- **Providers and Injectors:**
  - **Providers:** Define how to create a dependency.
  - **Injectors:** Responsible for instantiating and delivering dependencies.
  
- **Hierarchical Injectors:**
  - Angular has a hierarchical injector system, allowing different parts of the app to have their own instances of a service if needed.

**Example:**
- **Providing a Service at Different Levels:**
  - **Root Level:**
    ```typescript
    @Injectable({
      providedIn: 'root'
    })
    export class LoggerService {
      log(message: string) {
        console.log(message);
      }
    }
    ```
  - **Component Level:**
    ```typescript
    @Component({
      selector: 'app-dashboard',
      templateUrl: './dashboard.component.html',
      styleUrls: ['./dashboard.component.css'],
      providers: [LoggerService]
    })
    export class DashboardComponent { }
    ```
    - This creates a new instance of `LoggerService` specific to `DashboardComponent`.

---

### **2. Routing and Navigation**

#### **2.1. Setting Up Basic Routing**

**Objective:**  
Learn how to configure Angular's router to navigate between different views or components.

**Content:**

- **Importing RouterModule:**
  ```typescript
  // app.module.ts
  import { RouterModule, Routes } from '@angular/router';
  import { HomeComponent } from './home/home.component';
  import { AboutComponent } from './about/about.component';
  import { ContactComponent } from './contact/contact.component';

  const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'about', component: AboutComponent },
    { path: 'contact', component: ContactComponent },
    { path: '**', redirectTo: '' } // Wildcard route for a 404 page
  ];

  @NgModule({
    imports: [
      // ... other imports
      RouterModule.forRoot(routes)
    ],
    exports: [RouterModule],
    // ... declarations, bootstrap
  })
  export class AppModule { }
  ```

- **Adding Router Outlet:**
  ```html
  <!-- app.component.html -->
  <nav>
    <a routerLink="/">Home</a>
    <a routerLink="/about">About</a>
    <a routerLink="/contact">Contact</a>
  </nav>
  <router-outlet></router-outlet>
  ```

- **Creating Components for Routes:**
  ```bash
  ng generate component home
  ng generate component about
  ng generate component contact
  ```

---

#### **2.2. Navigating Between Routes and Understanding Route Parameters**

**Objective:**  
Master navigation between routes programmatically and using route parameters to pass data.

**Content:**

- **Navigating Programmatically:**
  ```typescript
  // home.component.ts
  import { Component } from '@angular/core';
  import { Router } from '@angular/router';

  @Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
  })
  export class HomeComponent {
    constructor(private router: Router) { }

    goToAbout(): void {
      this.router.navigate(['/about']);
    }
  }
  ```
  ```html
  <!-- home.component.html -->
  <h1>Welcome to the Home Page</h1>
  <button (click)="goToAbout()">Go to About</button>
  ```

- **Using Route Parameters:**
  ```typescript
  // app.module.ts (add a route with a parameter)
  const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'about/:id', component: AboutComponent },
    { path: 'contact', component: ContactComponent },
    { path: '**', redirectTo: '' }
  ];
  ```

  ```typescript
  // about.component.ts
  import { Component, OnInit } from '@angular/core';
  import { ActivatedRoute } from '@angular/router';

  @Component({
    selector: 'app-about',
    templateUrl: './about.component.html',
    styleUrls: ['./about.component.css']
  })
  export class AboutComponent implements OnInit {
    id: string | null = '';

    constructor(private route: ActivatedRoute) { }

    ngOnInit(): void {
      this.id = this.route.snapshot.paramMap.get('id');
    }
  }
  ```
  ```html
  <!-- about.component.html -->
  <h1>About Page</h1>
  <p>Route parameter ID: {{ id }}</p>
  ```

- **Navigating with Parameters:**
  ```typescript
  // home.component.ts (modified)
  goToAboutWithId(): void {
    this.router.navigate(['/about', 42]);
  }
  ```
  ```html
  <!-- home.component.html (modified) -->
  <button (click)="goToAboutWithId()">Go to About with ID</button>
  ```

---

### **3. Lifecycle Hooks**

#### **3.1. Introduction to Lifecycle Hooks**

**Objective:**  
Understand the purpose and usage of Angular's lifecycle hooks to manage component behavior throughout its lifecycle.

**Content:**

- **What are Lifecycle Hooks?**
  - Methods that Angular calls at specific points in a component's lifecycle.
  - Allow developers to tap into key moments like creation, change detection, and destruction.

- **Common Lifecycle Hooks:**
  - **`ngOnInit`**: Called once after the first `ngOnChanges`. Ideal for initialization logic.
  - **`ngOnDestroy`**: Called just before Angular destroys the component. Useful for cleanup.
  - **`ngOnChanges`**: Called when an input property changes.
  - **`ngAfterViewInit`**: Called after Angular initializes the component's views and child views.

---

#### **3.2. Implementing Lifecycle Hooks**

**Objective:**  
Learn how to implement and utilize lifecycle hooks in Angular components.

**Content:**

- **Using `ngOnInit`:**
  ```typescript
  // user.component.ts
  import { Component, OnInit } from '@angular/core';
  import { UserService } from './user.service';
  import { User } from './user.model';

  @Component({
    selector: 'app-user',
    templateUrl: './user.component.html',
    styleUrls: ['./user.component.css']
  })
  export class UserComponent implements OnInit {
    users: User[] = [];

    constructor(private userService: UserService) { }

    ngOnInit(): void {
      this.userService.getUsers().subscribe(users => {
        this.users = users;
        console.log('Users fetched on init');
      });
    }
  }
  ```

- **Using `ngOnDestroy`:**
  ```typescript
  // user.component.ts
  import { Component, OnInit, OnDestroy } from '@angular/core';
  import { UserService } from './user.service';
  import { User } from './user.model';
  import { Subscription } from 'rxjs';

  @Component({
    selector: 'app-user',
    templateUrl: './user.component.html',
    styleUrls: ['./user.component.css']
  })
  export class UserComponent implements OnInit, OnDestroy {
    users: User[] = [];
    private subscription: Subscription = new Subscription();

    constructor(private userService: UserService) { }

    ngOnInit(): void {
      this.subscription.add(
        this.userService.getUsers().subscribe(users => {
          this.users = users;
          console.log('Users fetched on init');
        })
      );
    }

    ngOnDestroy(): void {
      this.subscription.unsubscribe();
      console.log('UserComponent destroyed and subscription unsubscribed');
    }
  }
  ```

- **Using `ngOnChanges`:**
  ```typescript
  // child.component.ts
  import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';

  @Component({
    selector: 'app-child',
    template: `<p>Child component received: {{ data }}</p>`
  })
  export class ChildComponent implements OnChanges {
    @Input() data: string = '';

    ngOnChanges(changes: SimpleChanges): void {
      if (changes['data']) {
        console.log('Data changed:', changes['data'].currentValue);
      }
    }
  }
  ```

---

### **4. Additional Resources**

**Content:**

- **Documentation:**
  - [Angular Services and Dependency Injection](https://angular.io/guide/architecture-services)
  - [Angular Routing & Navigation](https://angular.io/guide/router)
  - [Angular Lifecycle Hooks](https://angular.io/guide/lifecycle-hooks)

- **Tutorials:**
  - [Building a CRUD Application with Angular](https://www.digitalocean.com/community/tutorials/angular-crud-app)
  - [Understanding Dependency Injection in Angular](https://www.freecodecamp.org/news/dependency-injection-in-angular/)

- **Tools:**
  - [Postman](https://www.postman.com/) for testing API endpoints.
  - [Angular CLI](https://angular.io/cli) for generating components, services, and modules.

