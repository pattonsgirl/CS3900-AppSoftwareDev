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

Before beginning, you (as a group) should revisit the group project portions in which you planned wireframes & your API implementation.  It is expected that not all planned endpoints were built.  
If the API endpoints are not functional, you'll need to flesh out the CRUD (endpoint) operations without API calls (although you can leave code sketches to future plan the API resource working).

Note that **most** wireframes will likely use form components to get input from users and **most** wireframes will display results in tables.  Use of flexbox will likely assist with putting components  
where you want them on a page.

In your group project GitHub repository, create a folder named `PROJECTTHEME-frontend`, replacing PROJECTHEME with your group's project theme.  
- Add a folder named `READMES` to the `PROJECTTHEME-frontend` folder.
- Leaning on the Web Design assignments, you are allowed to choose a group member to be the starting code base that worked out a good layout that the team would like to use as a base.
  - If you feel you have a good base as a team, have that member add their code to the `PROJECTTHEME-frontend` folder so that all team members can start from the same base.

> [!TIP] 
> Have team members on components / pages on different branches.  Name the branch with the corresponding components / pages.  Merge branches with `main` once branch components / pages are tested to  
not break the application on `main`.  The application state on `main` should always be functional

**Since each team member built a wireframe, I recommend having the same team member who built the wireframe take lead in building the page and it's components.**  How you as a team choose to  
distribute the work is up to the team - I will only be checking that all team members contributed in the commit history.  You may also have team members work on different approaches to the same  
component / wireframe if there are unique opinions on layout / interaction.

---

## 1. General Application Requirements

This section will outline the basis of what all applications must have - a navigation bar, a header, and a footer.  Whether you application has a dedicated homepage and expects users to head to  
the navigation bar, or if it display a buttoned menu of options (in addition to the navigation bar) is up to you as a group. 

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
    - For the navigation bar, follow requirement in 1.4. Navigation & Routing

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

## 2. Page / Component Development

This section will get into the specific of what pages on your application need to have.  Not all pages will need more than one component (in addition to using the generic components).  Not all pages will make use of all CRUD operations to call all types of endpoints (GET, PUT, POST, DELETE) - cases like this will be justified in the page README.

I'll reiterate that I would recommend assigning a group member to a wireframe, but if you as a group would rather break it into team members who manage component layout versus service layout versus testing, you as a group may make that call.

Each wireframe, in addition to utilizing the generic components of at minimum header, footer, and navigation bar, must  
- **implement a minimum of one component** unique to the page.  
  - [Section 2.1.](#21-components-requirements) details the component requirements
  - [Section 2.2.](#22-data-binding-and-directives) details data binding & directives requirements
  - [Section 2.3.](#23-forms-implementation) details form implementation requirements
  - [Section 2.4.](#24-component-methods) details component method requirements
  - [Section 2.5.](#25-service-integration) details service integration requirements
  - [Section 2.6.](#26-code-efficiency) details code efficiency requirements
  - [Section 2.7.](#27-unit-testing) details unit testing requirements
- have a `PAGENAME-README.md` file to document exemptions to the generic requirements.

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

- **Honors - Mobile Responsiveness:**
  - Ensure that content on each component on your assigned wireframe is mobile-friendly.
  - Implement responsive design techniques to provide a seamless experience across various devices.
  - Recommended testing sites:
    - [Chrome - Use Dev Tools](https://contextqa.com/mobile-version-of-a-website-on-chrome/)
    - [Chrome Extension - U-Eyes: Mobile Device Simulator](https://chromewebstore.google.com/detail/u-eyes-mobile-device-simu/pjldgnhfobpnhbdmfmofkfppdilefnjj?hl=en-US&utm_source=ext_sidebar&pli=1)
  - Note in `PAGE-README.md` if tasking was complete and if for HONORS or BONUS credit

- **Bonus - Advanced Styling:**
  - Incorporate CSS or TypeScript transitions for at least **one (1)** element within any of the components.
  - Utilize the `calc` function effectively in your CSS to demonstrate advanced styling capabilities.
  - Note in `PAGE-README.md` if tasking was complete for BONUS credit

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
  
  - **Bonus**
    - Inter-Component Communication:
      - Implement a subscription or signal within the service to facilitate communication between sibling components.
    - Utility Methods:
      - Develop one or more services that include at least **two (2)** commonly reused utility methods.
    - Note in `PAGE-README.md` if tasking was complete for BONUS credit

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

## Deliverables

- `main` contains the working pieces of the application frontend. 
- Pages with components with contributions by each team member.  
- If the team member does not have a working component / page, do not merge their code into `main`, leave it on the branch with documentation in `main` about the status / difficulties to show the teams where assistance / advice is needed.
- `PAGE-README` in `READMES` folder documenting exemptions to the assignment description for a given page

## Submission

Submit link to assignment repository in the Dropbox in Pilot.  Only ONE team member needs to remember to submit the link.

URL looks like: https://github.com/WSU-kduncan/cs3900-YOURGROUPNAME

## Rubric

Team members with no contributions to the team project GitHub repository will receive a 0.

If a team member did not build the page / components they were tasked with, the participating team members will not take a penalty.

If a team member helps another team member within polishing / debugging an page / component (and therefore makes contributions), there will not be a penalty on the team member who requested help.

If a page / component is not working (incomplete), partial credit is available for the work that was done.

### Total Score: 
- Total points among complete & incomplete pages / components / total earnable complete & incomplete points

### General application requirements: / 18 pts
- Angular project created
- `README.md` contains notes for how to run app
- For the three generic components: / 9
  - each has it's own HTML, CSS, and TypeScript files
  - each are declared and integrated within the application
  - each is present on every page (exception for modals / pop-ups)
- application homepage: / 2
  - exists, loads as default landing page
  - makes use of generic components
- CSS classes: / 1
  - minimum of 10 defined and utilized at both global and component levels
- Navigation / routing: / 2
  - Implement navigation between the components using Angular Routing
  - Define routes in a dedicated `app.routes.ts`
- Component communication: / 2
  - Establish communication between parent and child components using `@Input` and `@Output` decorators.
  - Define and utilize at least **two (2)** distinct object data models.

### Component requirements (for a min. of 1 component / page): / 17 pts per page
- Logically organized HTML content
- Styling with flexbox
- UI / UX principles utilized
- Utilizes at least **one (1)** instance of class binding
- Implements at least **one (1)** instance of style binding
- Use `*ngFor` to iterate over and display a list of items
- Apply `*ngIf` to conditionally render content
- At least **five (5)** unique component-level methods
- At least **one (1)** Angular service meeting the objectives: / 4
  - Implement Create, Read, Update, and Delete (CRUD) functionalities within the service.
  - Instantiate and utilize Angular's `HttpClient` within the service.
  - Correctly declare and inject the service as a dependency within at least **one (1)** component.
  - Demonstrate the service's usage through method calls and data handling within the component.
- Code demonstrates: / 3
  - componentization
  - method optimization
  - iterators
- Implement unit tests using Jest to validate component functionality and service methods.
- Achieve a minimum of **60%** code coverage across the project.

### Honors Score: / 2
- mobile responsiveness of the page / component
- 80% code coverage in testing of the page / component

### Bonus Score: / 4
- Incorporate CSS or TypeScript transitions for at least **one (1)** element within any of the components.
- Utilize the `calc` function effectively in your CSS to demonstrate advanced styling capabilities.
- Implement a subscription or signal within the service to facilitate communication between sibling components.
- Develop one or more services that include at least **two (2)** commonly reused utility methods.
