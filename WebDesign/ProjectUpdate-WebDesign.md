# Web Design - Angular Front-End Group Project Additions

## Purpose / Objectives

This project aims to provide students with hands-on experience in building a robust Angular front-end application using their group project theme. 

Students will demonstrate their understanding of Angular fundamentals, including:
- component creation
- service implementation
- routing
- state management
- testing 

The project is structured into two main sections: 
- [General Application Requirements](#1-general-application-requirements)
- [Wireframe Development](#2-wireframe-development)

---

## 1. General Application Requirements

### 1.1. Create the Angular Project

- **Initialize the Project:**
  - Utilize the Angular CLI to create a new Angular project using the following command:
    ```bash
    ng new [project-name]
    ```
  - Ensure that the project is set up with default configurations unless specified otherwise.

- **Verify Project Setup:**
  - Navigate into the project directory:
    ```bash
    cd [project-name]
    ```
  - Compile and run the project to ensure it starts without errors:
    ```bash
    ng serve
    ```
  - The application should be accessible at `http://localhost:4200/` in a web browser.

- **Documentation:**
  - `README.md` within the frontend application folder to instruct users / your teammates of the required steps to run the application.
    - Must include required installations & commands

### 1.2. Generic Required Components
- **Create Components:**
  - Generate at least **three (3)** distinct components for generic use across your application.  
  At minimum, you need a component for the header, footer, and navigation bar:
    ```bash
    ng generate component [component-name]
    ```
    *Example:*
    ```bash
    ng generate component header
    ng generate component footer
    ng generate component navbar
    ```

- **Component Requirements:**
  - Each generated component should have its own HTML, CSS, and TypeScript files.
  - Ensure that components are properly declared and integrated within the application.
  - These components should be present on every page (exception for modals / pop-ups)

- **Homepage Requirements:**
  - Your application should have a homepage or default application view / usage.
  - The homepage should must make use of the required components listed above.

### 1.3. **CSS Classes:**
    - Implement a minimum of **ten (10)** handwritten CSS classes.
    - Classes should be defined and utilized at both global and component levels.
    - **Note:** The use of CSS frameworks like Tailwind CSS or component libraries like PrimeNG  
    is permitted beyond the initial requirement.

### 1.4. Navigation and Routing

- **Coherent Navigation:**
  - Implement seamless navigation between the populated components using Angular Routing.
  
- **Routing Configuration:**
  - Define routes in a dedicated `app.routes.ts` file following Angular 18 conventions.
  
- **Navigation Elements:**
  - Incorporate at least **one (1)** navigation bar or dropdown menu within the application to facilitate user navigation.

### 1.5. Component Communication

- **Parent-Child Interaction:**
  - Establish communication between parent and child components using `@Input` and `@Output` decorators.
  
- **Data Models:**
  - Define and utilize at least **two (2)** distinct object data models.
    - Models can be implemented as either TypeScript interfaces or classes.
    - **Requirement:** Provide a rationale for choosing between an interface or a class (e.g., use of constructors in classes).

---

## 2. Wireframe Development

It is expected that during the UI / UX process, each team member created a unique wireframe for the group project application.  
Each group member will now be responsible for implementation of that wireframe, or the wireframe assigned to them by the group.

This section will detail the requirements for each wireframe.

Each wireframe, in addition to utilizing the generic components of at minimum header, footer, and navigation bar, must  
**implement a minimum of one component** unique to the wireframe.  
- [Section 2.1.](#21-components-requirements) details the component requirements
- [Section 2.2.](#22-data-binding-and-directives) details data binding & directives requirements
- [Section 2.3.](#23-forms-implementation) details form implementation requirements
- [Section 2.4.](#24-component-methods) details component method requirements
- [Section 2.5.](#25-service-integration) details service integration requirements
- [Section 2.6.](#26-code-efficiency) details code efficiency requirements
- [Section 2.7.](#27-unit-testing) details unit testing requirements

**NOTE** If your assigned wireframe has no purpose for a specifically required elements (in particular down in service integration),  
you may justify why it unsuitable in context of the wireframe and application intent.  Add justifications to a file named  
`exemptions.md`, with a content header of the wireframe / application page name applying for exemption. 

### 2.1. Component(s) Requirements

- **HTML Content:**
  - Each component must contain meaningful and relevant HTML content that aligns with its purpose.
  - Ensure the content is organized logically to enhance readability and user experience.

- **CSS Styling:**
  - Utilizes the CSS Styling declared for the application
  - **Flexbox Utilization:**
    - At least **one (1)** component must implement Flexbox for layout management.
    - Demonstrate responsive design practices using Flexbox properties.
  
- **UI/UX Standards:**
  - Content should be organized in a manner that reflects the UI/UX principles taught during the course.
  - Focus on creating intuitive and user-friendly interfaces.

- **Mobile Responsiveness (Honors Only):**
  - Ensure that content on each component on your assigned wireframe is mobile-friendly.
  - Implement responsive design techniques to provide a seamless experience across various devices.
  - Recommended testing sites:
    - [Chrome - Use Dev Tools](https://contextqa.com/mobile-version-of-a-website-on-chrome/)
    - [Chrome Extension - U-Eyes: Mobile Device Simulator](https://chromewebstore.google.com/detail/u-eyes-mobile-device-simu/pjldgnhfobpnhbdmfmofkfppdilefnjj?hl=en-US&utm_source=ext_sidebar&pli=1)

- **Advanced Styling (Bonus):**
  - Incorporate CSS or TypeScript transitions for at least **one (1)** element within any of the components.
  - Utilize the `calc` function effectively in your CSS to demonstrate advanced styling capabilities.

### 2.2. Data Binding and Directives

- **Class Binding:**
  - Utilize at least **one (1)** instance of class binding to dynamically assign CSS classes based on component state.

- **Style Binding:**
  - Implement at least **one (1)** instance of style binding to dynamically alter inline styles of elements.

- **Structural Directives:**
  - **ngFor:**
    - Use `*ngFor` to iterate over and display a list of items within the HTML templates.
  
  - **ngIf:**
    - Apply `*ngIf` to conditionally render content based on specific conditions or user interactions.

### 2.3. Forms Implementation

- **Form Types:**
  - Create **one (1)** different form within the wireframe using either a:
    - **Template-Driven Form:** Utilize Angular's template-driven forms for straightforward form handling.
    - **Reactive Form:** Implement a reactive form to demonstrate advanced form management and validation techniques.

### 2.4. Component Methods

- **Method Implementation:**
  - Develop at least **five (5)** unique component-level methods.
    - **Examples:**
      - Formatting data for display.
      - Displaying messages or notifications to users.
      - Manipulating form data based on user input.
  
  - Ensure that methods contribute to clear and productive functionality within the application.

### 2.5. Service Integration

- **Service Creation:**
  - Generate at least **one (1)** Angular service using the CLI:
    ```bash
    ng generate service [service-name]
    ```
  
- **Service Functionality:**
  - **CRUD Operations:**
    - Implement Create, Read, Update, and Delete (CRUD) functionalities within the service.
      - See exemptions note above if you do not have all of these functionalities needed by your wireframe.
    - Data manipulation can be limited to local data storage.
  
  - **HTTP Client Usage:**
    - Instantiate and utilize Angular's `HttpClient` within the service.
    - **Requirement:** Make actual HTTP requests to demonstrate understanding, even if the endpoints are mock or do not return real data.
  
  - **Honors Only - Inter-Component Communication:**
    - Implement a subscription or signal within the service to facilitate communication between sibling components.
  
  - **Bonus - Utility Methods:**
    - Develop one or more services that include at least **two (2)** commonly reused utility methods.

- **Service Consumption:**
  - Correctly declare and inject the service as a dependency within at least **one (1)** component.
  - Demonstrate the service's usage through method calls and data handling within the component.

### 2.6. Code Efficiency

- **Componentization:**
  - Ensure effective usage of component-based architecture.
  - Avoid duplicating HTML code across components; leverage reusable components where applicable.

- **Method Optimization:**
  - Eliminate redundant methods that perform identical functionalities by utilizing services.
  - Consolidate similar logic to maintain a clean and maintainable codebase.

- **Iterators:**
  - Use `*ngFor` to dynamically iterate over and display user-defined components, enhancing scalability.

### 2.7. Unit Testing

- **Testing Framework:**
  - Implement unit tests using Jest to validate component functionality and service methods.

- **Code Coverage:**
  - Achieve a minimum of **60%** code coverage across the project.
  
- **Honors Only - Enhanced Coverage (Bonus):**
  - Strive for **80%** or higher code coverage, ensuring comprehensive testing of critical application parts.

---

## Deliverables - TODO: Patch after reorg

### 1. Project Initialization
- Angular project created and verified using `ng new` and `ng serve`.
- At least four distinct components generated.

### 2. Component Development
- Each component contains organized HTML content.
- Flexbox utilized in at least one component.
- Minimum of ten handwritten CSS classes applied globally and within components.
- Mobile-friendly designs for honors-level projects.
- Media queries and CSS transitions implemented as per requirements.

### 3. Application Functionality
- Seamless navigation implemented via Angular Routing using `app.routes.ts`.
- Class binding, style binding, `ngFor`, and `ngIf` utilized effectively.
- Parent-child component communication established with `@Input` and `@Output`.
- Two distinct data models defined and used.
- Two forms (template-driven and reactive) implemented.
- Five component-level methods developed.
- At least one service with CRUD operations and HTTP client usage integrated.

### 4. Testing and Efficiency
- Effective componentization and method optimization demonstrated.
- `ngFor` used to iterate over user-defined components.
- Unit tests implemented with Jest achieving the required code coverage, preferably above 80%.

## Rubric - TODO

TODO
