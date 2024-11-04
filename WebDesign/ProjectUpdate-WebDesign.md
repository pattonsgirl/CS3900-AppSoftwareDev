### After Classes 1 & 2: Angular Environment Setup and Basic Components

**Deliverables**  
1. **Project Setup**:
   - Clone the repository and set up the Angular project.
   - Verify that the environment is correctly configured, with Angular CLI and Node.js.

2. **Basic Components**:
   - **Create**: A basic homepage layout and a Work Orders component with minimal styling.
   - **Implement**: A static navbar with placeholder links for Home, Work Orders, Customers, and Technicians.

3. **Data Binding and Directives**:
   - Set up a sample work order component with static data displayed using interpolation and property binding.
   - Use structural directives (`*ngIf` and `*ngFor`) for conditional display and looping over a sample list of work orders.

**Guidance**  
- **Focus on Reusability**: When creating the Work Orders component, think about which elements (e.g., work order cards, navigation buttons) could be reused across other pages.
- **Use a Simple List for Work Orders**: Add some placeholder data directly in the component’s TypeScript file to simulate a list of work orders (this can go in a `constants` directory).
- **Experiment with Basic Styling**: Apply Flexbox or Grid for layout, making the Work Orders component look organized and responsive.

---

### After Class 3: Services, Dependency Injection, and Routing

**Deliverables**  
1. **Services and Data Management**:
   - **Create**: A `WorkOrderService` to handle work order data and simulate CRUD operations.
   - **Implement**: A method within `WorkOrderService` to fetch a static list of work orders (mocked locally in your `constants` directory).
   - **Inject**: `WorkOrderService` into the Work Orders component to display data.

2. **Routing and Navigation**:
   - **Set Up**: Angular routing for Home, Work Orders, Customers, and Technicians pages.
   - **Add Links**: Update the navbar to include functional links for each of these routes.

**Guidance**  
- **Use Mock Data**: In `WorkOrderService`, start with hardcoded data. This will simulate real API calls later on.
- **Component Reusability**: Think about adding individual `WorkOrderItem` components within the Work Orders list, making it easy to update each work order’s view.
- **Test Routing Thoroughly**: Make sure each link in the navbar routes to the correct component, creating a user-friendly navigation experience.

---

### After Class 4: Forms and Validation

**Deliverables**  
1. **Forms for Work Order Creation**:
   - **Create**: A reactive form in the Work Orders component for adding/editing work orders.
   - **Add Fields**: Include fields for Customer Information, Work Order Details, Technician Assignment, and Status.
   - **Apply Validation**: Add validation for required fields, like Customer Name, Scheduled Date, and Technician.

2. **Form Validation and Error Messages**:
   - Display error messages when validation fails on required fields.
   - Implement conditional styling for invalid fields to help users understand required inputs.

**Guidance**  
- **Prioritize User Experience**: Make forms intuitive by grouping related fields (e.g., Customer Information, Work Details).
- **Use Validators for Required Fields**: Apply validators for all essential fields to simulate real application behavior.
- **Prepare for Data Persistence**: Set up your form in a way that it can easily connect to backend data.

---

### After Class 5: Performance Optimizations, Componentization, Services, Standalone Components, Assets & Models, and Unit Tests

**Deliverables**  
1. **Componentize Key Features Using Standalone Components**:
   - **Break Down**: The Work Orders page into smaller, focused standalone components, such as `WorkOrderItem`, `CustomerForm`, and `TechnicianForm`.
   - **Create Reusable Components**: Develop standalone components for common elements like buttons and notifications. For example, a `SharedButtonComponent` for different button styles and a `NotificationComponent` for feedback messages like "Work Order Saved" or "Validation Failed."

2. **Efficient Use of Services**:
   - **Refactor and Centralize**: Ensure `WorkOrderService`, `CustomerService`, and `TechnicianService` manage data interactions cleanly across components.
   - **Optimize Data Handling**: Use services to handle CRUD operations, keeping component logic focused on UI tasks.

3. **Organize Assets and Models**:
   - **Define Models**: Create clear interfaces or classes for core entities (e.g., `WorkOrder`, `Customer`, `Technician`) to ensure type safety across the application.
   - **Organize Assets**: Store commonly used assets (icons, images) in a centralized `assets` folder for easy access and maintenance.

4. **Unit Testing with Jest**:
   - **Write Tests for Standalone Components**: Test core UI behaviors for individual components, especially `WorkOrderForm`, `CustomerForm`, and `TechnicianForm`.
   - **Service Testing**: Achieve at least 80% code coverage by writing unit tests for service methods to confirm correct data handling.

**Guidance**  
- **Leverage Standalone Components**: Emphasize the use of standalone components over shared modules to keep imports minimal and only bring in necessary dependencies.
- **Reusability Without Modules**: Encourage students to reuse components by importing them directly where needed, without the need for a shared module.
- **Use `OnPush` Change Detection**: For performance, use `OnPush` change detection on standalone components where appropriate, especially for static data.
- **Emphasize Direct Imports**: Encourage direct imports of shared components, pipes, and directives into each standalone component. This aligns with modern Angular best practices and ensures components remain self-contained and reusable.
